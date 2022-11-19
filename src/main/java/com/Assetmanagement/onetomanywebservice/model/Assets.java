package com.Assetmanagement.onetomanywebservice.model;

import com.Assetmanagement.onetomanywebservice.model.dto.AssetsDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Assets")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    private Date purchasedate;
    private String condition;
    private String assignmentstatus;
    @ManyToOne
    private Categories categories;

    public static Assets from(AssetsDto assetsDto){
        Assets assets = new Assets();
        assets.setSerialNumber(assetsDto.getSerialNumber());
        return assets;
    }
}
