package com.min.coupang.service;

import com.min.coupang.entity.Product;
import com.min.coupang.entity.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ProductServiceImplTest {
    private ProductService productService;
    @Autowired
    public ProductServiceImplTest(ProductService productService) {
        this.productService = productService;
    }

    @Test
//    @Transactional
    void addProduct() {
        List<String> productCategory = List.of("냉동제품","육류","음료", "견과류", "가전제품");

        for (int i = 0; i < 5; i++) {
            Product product = Product.builder().name("상품"+i)
                    .productCategory(productCategory.get(i))
                    .price(i*1000L)
                    .productRating(i)
                    .productDiscount(0.1f*i)
                    .productStatus(ProductStatus.ROCKET_DELIVERY)
                    .build()
                    ;
            productService.addProduct(product);
        }
    }
    @Test
//    @Transactional
    void addProducts() {
        List<String> productCategory = List.of("냉동제품", "육류", "음료", "견과류", "가전제품", "의류", "가구", "서적", "주방용품", "화장품");

        Map<String, List<String>> categoryProductNames = Map.of(
                "냉동제품", List.of("냉동 만두", "냉동 피자", "냉동 감자튀김", "냉동 볶음밥", "냉동 치킨", "냉동 새우", "냉동 고구마", "냉동 딸기", "냉동 블루베리", "냉동 야채믹스"),
                "육류", List.of("한우 등심", "삼겹살", "돼지 목살", "닭가슴살", "양념 갈비", "소고기 불고기", "닭다리", "돈까스용 고기", "베이컨", "양갈비"),
                "음료", List.of("콜라", "사이다", "오렌지 주스", "사과 주스", "녹차", "커피", "이온 음료", "레몬 에이드", "토마토 주스", "생수"),
                "견과류", List.of("아몬드", "호두", "캐슈넛", "땅콩", "피스타치오", "마카다미아", "해바라기씨", "건포도", "크랜베리", "혼합 견과"),
                "가전제품", List.of("스마트 TV", "노트북", "블루투스 스피커", "전자레인지", "세탁기", "에어컨", "냉장고", "청소기", "커피 머신", "공기청정기"),
                "의류", List.of("청바지", "셔츠", "자켓", "코트", "원피스", "스웨터", "운동화", "양말", "모자", "장갑"),
                "가구", List.of("소파", "침대", "식탁", "의자", "책상", "옷장", "서랍장", "커피 테이블", "책장", "TV 스탠드"),
                "서적", List.of("소설", "에세이", "자기계발서", "역사책", "과학책", "요리책", "여행 가이드", "예술 서적", "경제 서적", "심리학 책"),
                "주방용품", List.of("프라이팬", "냄비", "칼", "도마", "접시 세트", "머그컵", "수저 세트", "믹서기", "전기밥솥", "오븐"),
                "화장품", List.of("스킨 로션", "페이셜 크림", "립스틱", "아이섀도우", "마스카라", "선크림", "에센스", "클렌징 오일", "BB크림", "미스트")
        );

        int productCount = 0;

        for (String category : productCategory) {
            List<String> productNames = categoryProductNames.get(category);

            for (String productName : productNames) {
                Product product = Product.builder()
                        .name(productName)
                        .productCategory(category)
                        .price((productCount + 1) * 1000L)
                        .productRating((productCount % 5) + 1)
                        .productDiscount(0.05f * productCount)
                        .productStatus(ProductStatus.ROCKET_DELIVERY)
                        .build();
                productService.addProduct(product);
                productCount++;
            }
        }
    }
}