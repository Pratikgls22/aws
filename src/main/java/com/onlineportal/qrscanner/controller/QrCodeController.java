package com.onlineportal.qrscanner.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.onlineportal.qrscanner.entity.ProductEntity;
import com.onlineportal.qrscanner.requestDto.ProductDto;
import com.onlineportal.qrscanner.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QrCodeController {

    private static final String APP_URL = "http://192.168.10.88:9091/api/products";

    @Autowired
    private ProductService productService;

    @GetMapping("/generate-qr")
    public void generateQrCode(HttpServletResponse response) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(APP_URL, BarcodeFormat.QR_CODE, 300, 300);
        response.setContentType("image/png");
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getProducts() {
        try {
            // Fetch products from the service
            var products = this.productService.getProducts();
            // Check if the list is empty
            if (products == null || products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
            }
            return new ResponseEntity<>(products, HttpStatus.OK); // 200 OK
        } catch (Exception e) {
            // Log the exception (you may want to log this properly)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }

    @PostMapping("/createproduct")
    public ProductEntity createProduct(@RequestBody ProductDto productDto){
        return this.productService.createProducts(productDto);
    }

    // For Get Elasticsearch Data
//    @GetMapping("/search-products")
//    public ResponseEntity<List<ProductElasticEntity>> searchProducts(@RequestParam String keyword) {
//        try {
//            // Fetch products from Elasticsearch based on the keyword
//            var products = productService.searchProducts(keyword);
//            if (products == null || products.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
//            }
//            return new ResponseEntity<>(products, HttpStatus.OK); // 200 OK
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
//        }
//    }

}
