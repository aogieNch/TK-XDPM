package pm02.cameraWebSeller.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pm02.cameraWebSeller.data_access.entity.Product;
import pm02.cameraWebSeller.data_access.entity.Title;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private Product product;
    private List<Title> titles;
}

