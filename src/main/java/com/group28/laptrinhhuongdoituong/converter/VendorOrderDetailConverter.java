package com.group28.laptrinhhuongdoituong.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.group28.laptrinhhuongdoituong.dto.VendorOrderDetailDTO;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailEntity;
import com.group28.laptrinhhuongdoituong.entity.VendorOrderDetailKey;
import com.group28.laptrinhhuongdoituong.service.implement.ProductService;
import com.group28.laptrinhhuongdoituong.service.implement.VendorOrderService;

@Component
public class VendorOrderDetailConverter {
  
  @Autowired
  private VendorOrderService vendorOrderService;

  @Autowired
  private ProductService productService;

  public VendorOrderDetailDTO toDTO(VendorOrderDetailEntity vendorOrderDetailEntity) {
    VendorOrderDetailDTO vendorOrderDetailDTO = new VendorOrderDetailDTO();
    vendorOrderDetailDTO.setVendor_order_id(vendorOrderDetailEntity.getVendor_order_id().getId());
    vendorOrderDetailDTO.setProduct_id(vendorOrderDetailEntity.getProduct_id().getId());
    vendorOrderDetailDTO.setAmount(vendorOrderDetailEntity.getAmount());
    vendorOrderDetailDTO.setPrice(vendorOrderDetailEntity.getPrice());
    vendorOrderDetailDTO.setDeleted(vendorOrderDetailEntity.getDeleted());

    return vendorOrderDetailDTO;
  }

  public VendorOrderDetailEntity toEntity(VendorOrderDetailDTO vendorOrderDetailDTO) {
    VendorOrderDetailEntity vendorOrderDetailEntity = new VendorOrderDetailEntity();
    VendorOrderDetailKey key = new VendorOrderDetailKey();
    key.setVendorOrderId(vendorOrderDetailDTO.getVendor_order_id());
    key.setProductId(vendorOrderDetailDTO.getProduct_id());
    vendorOrderDetailEntity.setId(key);
    vendorOrderDetailEntity.setVendor_order_id(vendorOrderService.findVendorOrderById(vendorOrderDetailDTO.getVendor_order_id()));
    vendorOrderDetailEntity.setProduct_id(productService.findProductById(vendorOrderDetailDTO.getProduct_id()));
    vendorOrderDetailEntity.setAmount(vendorOrderDetailDTO.getAmount());
    vendorOrderDetailEntity.setPrice(vendorOrderDetailDTO.getPrice());
    vendorOrderDetailEntity.setDeleted(vendorOrderDetailDTO.getDeleted());

    return vendorOrderDetailEntity;
  }
}
