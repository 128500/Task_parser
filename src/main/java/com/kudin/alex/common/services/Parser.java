package com.kudin.alex.common.services;

import com.kudin.alex.common.entities.Tire;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KUDIN ALEKSANDR on 22.01.2018.
 */

@Service
public class Parser {

    public List<Tire> parseFile(final String filePath){
        return parseData(openFile(filePath));
    }

    private Workbook openFile(final String filePath){
        try(FileInputStream fis = new FileInputStream(new File(filePath))){
            return new HSSFWorkbook(fis);
        } catch (FileNotFoundException e1){
            System.out.println("CANNOT FIND FILE WITH THE GIVEN PATH!");
            e1.printStackTrace();
        } catch(IOException e2){
            System.out.println("CANNOT OPEN THE GIVEN FILE!");
            e2.printStackTrace();
        }
        throw new IllegalStateException("CANNOT FIND OR OPEN FILE!");
    }

    private List<Tire> parseData(final Workbook workbook){
        List<Tire> tires = new ArrayList<>();
        try{
            Sheet sheet = workbook.getSheetAt(0);
            int rowNumber = sheet.getLastRowNum()+1;

            for(int i = 3; i<= rowNumber; i++){
                Row r = sheet.getRow(i);
                Tire t = null;
                if(r != null){
                    String tireName = r.getCell(2).getStringCellValue();
                    if(tireName != null && !tireName.isEmpty()){
                        t = parseString(tireName);
                    }
                    else{
                        System.out.println("CELL AT ROW " + i + " AND COLUMN " + 3 + " IS EMPTY");
                        System.out.println("INFO OF THIS ROW WON'T BE SAVED");
                        break;
                    }
                    t.setType(r.getCell(0).getStringCellValue());
                    t.setSeason(r.getCell(1).getStringCellValue());
                    t.setBalance((int)r.getCell(3).getNumericCellValue());
                    t.setPrice(r.getCell(4).getNumericCellValue());
                    t.setCountry(r.getCell(5).getStringCellValue());

                    if(r.getCell(6).getCellTypeEnum().equals(CellType.NUMERIC)) {
                        int year = (int)r.getCell(6).getNumericCellValue();
                        String yearr = String.valueOf(year);
                        if (yearr.length() > 2) {
                            if (yearr.length() == 3) {
                                year = Integer.valueOf(yearr.substring(1, 3)) + 2000;
                            } else year = Integer.valueOf(yearr.substring(2, 4)) + 2000;
                        }
                        else year += 2000;
                        t.setYear(year);
                    }

                    if(r.getCell(6).getCellTypeEnum().equals(CellType.STRING)){
                        t.setYear(0);
                    }

                    tires.add(t);
                    System.out.println(t.toString());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tires;
    }

    private Tire parseString(final String info){
        Tire t = new Tire();
        String[] parts = info.split(" ");

        t.setWidth(Integer.valueOf(parts[0].substring(0, 3)));

        t.setHeight(Integer.valueOf(parts[0].substring(4)));

        t.setDiameter(Integer.valueOf(parts[1].substring(1, 3)));

        if(parts[1].contains("C")){
            t.setStrengthen(true);
        }

        t.setManufacturer(parts[2]);

        if(parts[4].matches("\\d{2}T")){
            t.setModel(parts[3]);
            t.setLoadIndex(Integer.valueOf(parts[4].substring(0,2)));
            t.setSpeedIndex(parts[4].charAt(2));
        }

        if(parts.length >= 6){
            if(parts[5].matches("\\d{2}T")){
                t.setModel(parts[3] + " " + parts[4]);
                t.setLoadIndex(Integer.valueOf(parts[5].substring(0,2)));
                t.setSpeedIndex(parts[5].charAt(2));
            }
            if(parts[5].matches("XL")){
                t.setStrengthen(true);
            }
            if(parts[5].matches("шип")){
                t.setStudded(true);
            }
            if(parts[5].matches("[^XL]{1,2}")){
                t.setAdditionalParam(parts[5]);
            }
        }

        if(parts.length >= 7){
            if(parts[6].matches("\\d{2}T")){
                t.setModel(parts[3] + " " + parts[4] + " " + parts[5]);
                t.setLoadIndex(Integer.valueOf(parts[6].substring(0,2)));
                t.setSpeedIndex(parts[6].charAt(2));
            }
            if(parts[6].matches("XL")){
                t.setStrengthen(true);
            }
            if(parts[6].matches("шип")){
                t.setStudded(true);
            }
            if(parts[6].matches("[^XL]{1,2}")){
                t.setAdditionalParam(parts[5]);
            }
        }

        if(parts.length >= 8){
            if(parts[7].matches("\\d{2}T")){
                t.setModel(parts[3] + " " + parts[4] + " " + parts[5] + " " + parts[6]);
                t.setLoadIndex(Integer.valueOf(parts[7].substring(0,2)));
                t.setSpeedIndex(parts[7].charAt(2));
            }
            if(parts[7].matches("XL")){
                t.setStrengthen(true);
            }
            if(parts[7].matches("шип")){
                t.setStudded(true);
            }
            if(parts[7].matches("[^XL]{1,2}")){
                t.setAdditionalParam(parts[5]);
            }
        }
        if(t.getAdditionalParam() == null) t.setAdditionalParam("-");

        return t;
    }
}
