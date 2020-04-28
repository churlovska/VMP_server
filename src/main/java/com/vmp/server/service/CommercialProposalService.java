package com.vmp.server.service;

import com.vmp.server.entities.CommercialProposalEntity;
import com.vmp.server.entities.EstimateEntity;
import com.vmp.server.entities.PreparedCommercialProposalEntity;
import com.vmp.server.repositories.*;
import com.vmp.server.response.CPResponse;
import com.vmp.server.response.EstimateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommercialProposalService {

    @Autowired
    CityRep cityRep;

    @Autowired
    EstimateRep estimateRep;

    @Autowired
    CommercialProposalRep commercialProposalRep;

    @Autowired
    PreparedCommercialProposalRep preparedCommercialProposalRep;

    @Autowired
    AdvertisingObjectRep advertisingObjectRep;

    @Transactional
    public boolean createCP(int id, CPResponse newCP) {

        try {
            CommercialProposalEntity commercialProposalEntity = new CommercialProposalEntity();
            List<EstimateResponse> estimateResponses = new ArrayList<>(newCP.getEstimateList());
            List<Integer> advObjects = new ArrayList<>(newCP.getAdvObjectsId());

            commercialProposalEntity.setBrand(newCP.getBrand());
            commercialProposalEntity.setClient(newCP.getClient());
            commercialProposalEntity.setCreating_date(newCP.getCreating_date());
            commercialProposalEntity.setDate_from(newCP.getDate_from());
            commercialProposalEntity.setDate_to(newCP.getDate_to());
            commercialProposalEntity.setName(newCP.getName());
            commercialProposalEntity.setPlacing_format(newCP.getPlacing_format());
            commercialProposalEntity.setFinal_price(newCP.getFinal_price());

            commercialProposalRep.save(commercialProposalEntity);

            for (EstimateResponse o : estimateResponses) {
                estimateRep.save(new EstimateEntity(commercialProposalEntity, cityRep.findByCity(o.getCity()), o.getAo_count(),
                        o.getPrice(), o.getDuration(), o.getDiscount(), o.getStrategic_discount(), o.getDiscount_price(),
                        o.getFinal_price(), o.getVisits_traffic(), o.getOts_contacts(), o.getCoverage_people(), o.getCpt(), o.getPrice_poster_b1()));
            }

            for (Integer o : advObjects) {
                preparedCommercialProposalRep.save(new PreparedCommercialProposalEntity(advertisingObjectRep.getOne(o),
                        commercialProposalEntity));
            }
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
