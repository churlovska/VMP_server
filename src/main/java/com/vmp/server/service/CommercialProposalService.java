package com.vmp.server.service;

import com.vmp.server.entities.AdvertisingObjectEntity;
import com.vmp.server.entities.CommercialProposalEntity;
import com.vmp.server.entities.EstimateEntity;
import com.vmp.server.entities.PreparedCommercialProposalEntity;
import com.vmp.server.repositories.*;
import com.vmp.server.response.AOListResponse;
import com.vmp.server.response.CPRequest;
import com.vmp.server.response.CPResponse;
import com.vmp.server.response.EstimateResponse;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
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
    public boolean createCP(int id, CPRequest newCP) {

        try {
            CommercialProposalEntity commercialProposalEntity = new CommercialProposalEntity();
            List<EstimateResponse> estimateResponses = new ArrayList<>(newCP.getEstimateList());
            List<Integer> advObjects = new ArrayList<>(newCP.getAdvObjectsId());

            commercialProposalEntity.setBrand(newCP.getBrand());
            commercialProposalEntity.setClient(newCP.getClient());
            commercialProposalEntity.setCreatingDate(newCP.getCreating_date());
            commercialProposalEntity.setDate_from(newCP.getDate_from());
            commercialProposalEntity.setDate_to(newCP.getDate_to());
            commercialProposalEntity.setName(newCP.getName());
            commercialProposalEntity.setPlacing_format(newCP.getPlacing_format());
            commercialProposalEntity.setAo_count_comm(newCP.getAo_count_comm());
            commercialProposalEntity.setCoverage_comm(newCP.getCoverage_comm());
            commercialProposalEntity.setCpt_comm(newCP.getCpt_comm());
            commercialProposalEntity.setOts_comm(newCP.getOts_comm());
            commercialProposalEntity.setPrice_comm(newCP.getPrice_comm());
            commercialProposalEntity.setTraffic_comm(newCP.getTraffic_comm());
            commercialProposalEntity.setB1_price(newCP.getB1_price());
            commercialProposalEntity.setPlacement_fin(newCP.getPlacement_fin());
            commercialProposalEntity.setPrice_vat_fin(newCP.getPrice_vat_fin());
            commercialProposalEntity.setPrice_fin(newCP.getPrice_fin());

            commercialProposalRep.save(commercialProposalEntity);

            for (EstimateResponse o : estimateResponses) {
                estimateRep.save(new EstimateEntity(commercialProposalEntity, cityRep.findByCity(o.getCity()), o.getAo_count(),
                        o.getPrice(), o.getDuration(), o.getDiscount(), o.getStrategic_discount(), o.getDiscount_price(),
                        o.getFinal_price(), o.getVisits_traffic(), o.getOts_contacts(), o.getCoverage_people(), o.getCpt()));
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

    public String createExcel(CPRequest newCP) {

        try {

            List<EstimateResponse> estimateResponses = new ArrayList<>(newCP.getEstimateList());
            List<Integer> advObjects = new ArrayList<>(newCP.getAdvObjectsId());

            int rowInd = 0;

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet(newCP.getName());
            sheet.setColumnWidth(0, 6000);
            sheet.setColumnWidth(1, 6000);
            sheet.setColumnWidth(2, 6000);
            sheet.setColumnWidth(3, 6000);
            sheet.setColumnWidth(4, 6000);
            sheet.setColumnWidth(5, 6000);
            sheet.setColumnWidth(6, 6000);
            sheet.setColumnWidth(7, 6000);
            sheet.setColumnWidth(8, 6000);
            sheet.setColumnWidth(9, 6000);
            sheet.setColumnWidth(10, 6000);
            sheet.setColumnWidth(11, 6000);

            Row header = sheet.createRow(rowInd);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFFont font = ((XSSFWorkbook) workbook).createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 16);
            headerStyle.setFont(font);

            Cell headerCell = header.createCell(0);
            headerCell.setCellValue("Коммерческое предложение VITA Media");
            headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            headerCell.setCellStyle(headerStyle);

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);

            rowInd +=2;
            Row row = sheet.createRow(rowInd);
            Cell cell = row.createCell(0);
            cell.setCellValue(newCP.getName());
            cell.setCellStyle(style);

            rowInd++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Клиент:");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getClient());
            cell.setCellStyle(style);

            rowInd++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Бренд:");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getBrand());
            cell.setCellStyle(style);

            rowInd++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Формат:");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getPlacing_format());
            cell.setCellStyle(style);

            rowInd += 2;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Период:");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("с " + newCP.getDate_from() + " по " + newCP.getDate_to());
            cell.setCellStyle(style);

            rowInd++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Дата создания:");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(String.valueOf(newCP.getCreating_date()));
            cell.setCellStyle(style);

            rowInd += 2;
            header = sheet.createRow(rowInd);
            headerCell = header.createCell(0);
            headerCell.setCellValue("Смета");
            headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            headerCell.setCellStyle(headerStyle);

            rowInd += 2;
            row = sheet.createRow(rowInd);
            cell = row.createCell(8);
            cell.setCellValue("Медиапоказатели за 1 месяц");
            cell.setCellStyle(style);
            sheet.addMergedRegion(CellRangeAddress.valueOf("I13:L13"));

            rowInd++;
            row = sheet.createRow(rowInd);

            fillEstimateRow(style, row, "Регион", "Количество рекламных поверхностей, шт.","Стоимость размещения 1 рекламного носителя за 1 месяц, руб., без НДС",
                    "Длительность размещения (мес.)","Скидка, объём + период", "Стратегическая скидка",
                    "Стоимость размещения 1 рекламного носителя за 1 месяц после скидок, руб., без НДС","Итого, бюджет, руб., без НДС",
                    "Трафик (посещения)", "OTS (контакты)", "Охват (люди)", "CPT (руб.)");

            for (EstimateResponse o: estimateResponses) {
                rowInd++;
                row = sheet.createRow(rowInd);

                fillEstimateRow(style, row, o.getCity(), String.valueOf(o.getAo_count()), String.valueOf(o.getPrice()),
                        String.valueOf(o.getDuration()), o.getDiscount(), String.valueOf(o.getStrategic_discount()),
                        String.valueOf(o.getDiscount_price()), String.valueOf(o.getFinal_price()), String.valueOf(o.getVisits_traffic()),
                        String.valueOf(o.getOts_contacts()), String.valueOf(o.getCoverage_people()), String.valueOf(o.getCpt()));
            }

            rowInd++;
            row = sheet.createRow(rowInd);

            fillEstimateRow(style, row, "Итого", String.valueOf(newCP.getAo_count_comm()), "", "", "", "", "", String.valueOf(newCP.getPrice_comm()),
                    String.valueOf(newCP.getTraffic_comm()), String.valueOf(newCP.getOts_comm()), String.valueOf(newCP.getCoverage_comm()), String.valueOf(newCP.getCpt_comm()));

            rowInd += 2;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Итого, размещение");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getPlacement_fin());
            cell.setCellStyle(style);

            rowInd ++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Производство плакатов В1");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getB1_price());
            cell.setCellStyle(style);

            rowInd ++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Общий бюджет, размещение + производство, без НДС");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getPrice_fin());
            cell.setCellStyle(style);

            rowInd ++;
            row = sheet.createRow(rowInd);
            cell = row.createCell(0);
            cell.setCellValue("Общий бюджет, размещение + производство, с учётом НДС");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue(newCP.getPrice_vat_fin());
            cell.setCellStyle(style);

            rowInd += 2;
            header = sheet.createRow(rowInd);
            headerCell = header.createCell(0);
            headerCell.setCellValue("Адресная программа");
            headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            headerCell.setCellStyle(headerStyle);

            rowInd++;
            row = sheet.createRow(rowInd);

            fillEstimateRow(style, row, "№", "Город", "Объект", "Фактический адрес", "Этаж", "Сегмент", "Тип ЛПУ", "Социальная значимость ЛПУ",
                    "","", "", "");

            int i = 1;

            for (Integer o: advObjects) {
                rowInd++;
                row = sheet.createRow(rowInd);
                AdvertisingObjectEntity advertisingObjectEntity = advertisingObjectRep.getOne(o);
                fillEstimateRow(style, row, String.valueOf(i), advertisingObjectEntity.getCity().getCity(), advertisingObjectEntity.getName(), advertisingObjectEntity.getAddress(),
                        String.valueOf(advertisingObjectEntity.getFloor()), advertisingObjectEntity.getSegment().getSegment(), advertisingObjectEntity.getMi_type().getType(),
                        advertisingObjectEntity.getMi().getSignificance(), "","","","");
                i++;
            }

//            String fileLocation = FileSystems.getDefault()
//                    .getPath("")
//                    .toAbsolutePath()
//                    .toString();
//
//            System.out.println(fileLocation);

            String fileLocation = "d:\\TMP\\" + newCP.getName() + ".xlsx";

            FileOutputStream outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();

            return fileLocation;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private void fillEstimateRow(CellStyle style, Row row, String cell0, String cell1, String cell2, String cell3, String cell4, String cell5, String cell6, String cell7, String cell8, String cell9, String cell10, String cell11) {
        Cell cell = row.createCell(0);
        cell.setCellValue(cell0);
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue(cell1);
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue(cell2);
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue(cell3);
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue(cell4);
        cell.setCellStyle(style);
        cell = row.createCell(5);
        cell.setCellValue(cell5);
        cell.setCellStyle(style);
        cell = row.createCell(6);
        cell.setCellValue(cell6);
        cell.setCellStyle(style);
        cell = row.createCell(7);
        cell.setCellValue(cell7);
        cell.setCellStyle(style);
        cell = row.createCell(8);
        cell.setCellValue(cell8);
        cell.setCellStyle(style);
        cell = row.createCell(9);
        cell.setCellValue(cell9);
        cell.setCellStyle(style);
        cell = row.createCell(10);
        cell.setCellValue(cell10);
        cell.setCellStyle(style);
        cell = row.createCell(11);
        cell.setCellValue(cell11);
        cell.setCellStyle(style);
    }

    public CPResponse selectCPById (Integer id) {

        CPResponse cpResponse = new CPResponse();
        CommercialProposalEntity commercialProposalEntity = commercialProposalRep.getOne(id);

        cpResponse.setName(commercialProposalEntity.getName());
        cpResponse.setClient(commercialProposalEntity.getClient());
        cpResponse.setBrand(commercialProposalEntity.getBrand());
        cpResponse.setPlacing_format(commercialProposalEntity.getPlacing_format());
        cpResponse.setDate_from(commercialProposalEntity.getDate_from());
        cpResponse.setDate_to(commercialProposalEntity.getDate_to());
        cpResponse.setCreating_date(commercialProposalEntity.getCreatingDate());
        cpResponse.setPlacement_fin(commercialProposalEntity.getPlacement_fin());
        cpResponse.setB1_price(commercialProposalEntity.getB1_price());
        cpResponse.setPrice_fin(commercialProposalEntity.getPrice_fin());
        cpResponse.setPrice_vat_fin(commercialProposalEntity.getPrice_vat_fin());

        ArrayList<PreparedCommercialProposalEntity> preparedCommercialProposalEntities = preparedCommercialProposalRep.findByCommProposal(commercialProposalEntity);
        ArrayList<AOListResponse> aoListResponses = new ArrayList<>();

        for (PreparedCommercialProposalEntity o: preparedCommercialProposalEntities) {
            aoListResponses.add(new AOListResponse(o.getAdvertisingObject().getId(), o.getAdvertisingObject().getCity().getCity(),
                    o.getAdvertisingObject().getName(), o.getAdvertisingObject().getAddress(), o.getAdvertisingObject().getFloor(),
                    o.getAdvertisingObject().getSegment().getSegment(), o.getAdvertisingObject().getMi_type().getType(),
                    o.getAdvertisingObject().getMi().getSignificance()));
        }

        cpResponse.setAdvObjects(aoListResponses);

        ArrayList<EstimateEntity> estimateEntities = estimateRep.findAllByCpId(commercialProposalEntity);
        ArrayList<EstimateResponse> estimateResponses = new ArrayList<>();

        for (EstimateEntity o: estimateEntities) {
            estimateResponses.add(new EstimateResponse(o.getCity_id().getCity(), o.getAo_count(),
                    o.getPrice(), o.getDuration(), o.getDiscount(), o.getStrategic_discount(), o.getDiscount_price(),
                    o.getFinal_price(), o.getVisits_traffic(), o.getOts_contacts(), o.getCoverage_people(), o.getCpt()));
        }

        estimateResponses.add(new EstimateResponse("Итого", commercialProposalEntity.getAo_count_comm(),
                commercialProposalEntity.getPrice_comm(), commercialProposalEntity.getTraffic_comm(),
                commercialProposalEntity.getOts_comm(), commercialProposalEntity.getCoverage_comm(), commercialProposalEntity.getCpt_comm()));

        cpResponse.setEstimateList(estimateResponses);
        return cpResponse;
    }
}
