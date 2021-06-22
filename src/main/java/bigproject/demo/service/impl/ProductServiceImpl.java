package bigproject.demo.service.impl;

import bigproject.demo.model.entities.ProductEntity;
import bigproject.demo.model.entities.enums.GenderEnum;
import bigproject.demo.model.service.ProductServiceModel;
import bigproject.demo.repository.ProductRepository;
import bigproject.demo.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CloudinaryService cloudinaryService;



    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, UserService userService, CloudinaryService cloudinaryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userService = userService;
        this.cloudinaryService = cloudinaryService;
    }



    @Override
    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }


    @Override
    public void addNewProduct(ProductServiceModel model) throws IOException {
        MultipartFile img = model.getImgInput();
        String imageUrl = cloudinaryService.uploadImage(img);
        ProductEntity product = modelMapper.map(model, ProductEntity.class);
        product.setImgUrl(imageUrl);
        productRepository.save(product);
//        System.out.println();
    }


    @Override
    public void initProducts() {
        if(productRepository.count()==0){
            //kucheta

            ProductEntity productEntity = new ProductEntity()
                    .setName("Koko")
                    .setBreed("Pekines")
                    .setGender(GenderEnum.MALES)
                    .setBirthDate(LocalDate.of(2020,10,22))
                    .setPrice(BigDecimal.valueOf(3432))
                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675552/initPicture/kuche/%D0%BF%D0%B5%D0%BA%D0%B8%D0%BD%D0%B5%D1%81_bktu3l.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Lucky")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(1233))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Golden retriver")
                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675552/initPicture/kuche/%D0%B3%D0%BE%D0%BB%D0%B4%D1%8A%D0%BD_%D1%80%D0%B5%D1%82%D1%80%D0%B8%D0%B2%D1%8A%D1%80_evqd3t.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Gosho")
                    .setBirthDate(LocalDate.of(2020,6,14))
                    .setPrice(BigDecimal.valueOf(1233))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Bigal")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675552/initPicture/kuche/%D0%B1%D0%B8%D0%B3%D1%8A%D0%BB_sk90dw.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Sonya")
                    .setBirthDate(LocalDate.of(2020,12,28))
                    .setPrice(BigDecimal.valueOf(411))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Nemska ovcharka")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675552/initPicture/kuche/%D0%BD%D0%B5%D0%BC%D1%81%D0%BA%D0%B0_%D0%BE%D0%B2%D1%87%D0%B0%D1%80%D0%BA%D0%B0_rhx63d.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Hacki")
                    .setBirthDate(LocalDate.of(2020,7,9))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Akita anu")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675552/initPicture/kuche/%D0%B0%D0%BA%D0%B8%D1%82%D0%B0_%D0%B8%D0%BD%D1%83_xwevnm.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Camila")
                    .setBirthDate(LocalDate.of(2020,8,14))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Chao Chao")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675489/initPicture/kuche/%D1%87%D0%B0%D0%BE_%D1%87%D0%B0%D0%BE_ku1tsf.jpg");
            this.productRepository.save(productEntity);

            // kotki
            productEntity = new ProductEntity()
                    .setName("Mara")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Yaponski bobtail")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675539/initPicture/kotki/%D0%AF%D0%BF%D0%BE%D0%BD%D1%81%D0%BA%D0%B8_%D0%B1%D0%BE%D0%B1%D1%82%D0%B5%D0%B9%D0%BB_folxgi.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Snow")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Sibirska kotka")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675384/initPicture/kotki/%D0%A1%D0%B8%D0%B1%D0%B8%D1%80%D1%81%D0%BA%D0%B0_%D0%BA%D0%BE%D1%82%D0%BA%D0%B0_nh3mws.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Roza")
                    .setBirthDate(LocalDate.of(2020,3,22))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Siamska kotka")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675384/initPicture/kotki/%D1%81%D0%B8%D0%B0%D0%BC%D1%81%D0%BA%D0%B0_%D0%BA%D0%BE%D1%82%D0%BA%D0%B0_wu4tq6.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Puffy")
                    .setBirthDate(LocalDate.of(2021,2,18))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Persiiska kotka malka")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675359/initPicture/kotki/%D0%9F%D0%B5%D1%80%D1%81%D0%B8%D0%B9%D1%81%D0%BA%D0%B0_%D0%BA%D0%BE%D1%82%D0%BA%D0%B0_%D0%BC%D0%B0%D0%BB%D0%BA%D0%B0_t81jah.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Mini")
                    .setBirthDate(LocalDate.of(2020,11,29))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Persiiska kotka golyama")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675357/initPicture/kotki/%D0%BF%D0%B5%D1%80%D1%81%D0%B8%D0%B9%D1%81%D0%BA%D0%B0_%D0%BA%D0%BE%D1%82%D0%BA%D0%B0_%D0%B3%D0%BE%D0%BB%D1%8F%D0%BC%D0%B0_j3ubze.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Faraon")
                    .setBirthDate(LocalDate.of(2020,4,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Kanadski sfinks")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675350/initPicture/kotki/%D0%9A%D0%B0%D0%BD%D0%B0%D0%B4%D1%81%D0%BA%D0%B8_%D1%81%D1%84%D0%B8%D0%BD%D0%BA%D1%81_kw8vad.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Mila")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Britanska kasokosmesta")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675341/initPicture/kotki/%D0%91%D1%80%D0%B8%D1%82%D0%B0%D0%BD%D1%81%D0%BA%D0%B0_%D0%BA%D1%8A%D1%81%D0%BE%D0%BA%D0%BE%D1%81%D0%BC%D0%B5%D1%81%D1%82%D0%B0_%D0%BA%D0%BE%D1%82%D0%BA%D0%B0_wvcfuo.jpg");
            this.productRepository.save(productEntity);

            //ribki
            productEntity = new ProductEntity()
                    .setName("Riko")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Zlatna ribka")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675465/initPicture/ribi/%D0%97%D0%BB%D0%B0%D1%82%D0%BD%D0%B0_%D1%80%D0%B8%D0%B1%D0%BA%D0%B0_wbngor.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Kiro")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Riba Papagal")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675464/initPicture/ribi/%D1%80%D0%B8%D0%B1%D0%B0_%D0%BF%D0%B0%D0%BF%D0%B0%D0%B3%D0%B0%D0%BB_2_wa0ajo.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Roki")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Riba Papagal")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675464/initPicture/ribi/%D1%80%D0%B8%D0%B1%D0%B0_%D0%BF%D0%B0%D0%BF%D0%B0%D0%B3%D0%B0%D0%BB_1_egurrc.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Silvia")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Skalariya")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675504/initPicture/ribi/%D1%81%D0%BA%D0%B0%D0%BB%D0%B0%D1%80%D0%B8%D1%8F_jorwmy.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Riko")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Heler")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616675465/initPicture/ribi/%D0%A5%D0%B5%D0%BB%D0%B5%D1%80_k6s9lm.jpg");
            this.productRepository.save(productEntity);

            // ptici

            productEntity = new ProductEntity()
                    .setName("Dovecio")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Dove")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677289/initPicture/ptici/galab_jcqj89.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Mandoliya")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Kanarche")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677290/initPicture/ptici/kanarche_cs6whw.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Vasko")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Papagal Ara")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677290/initPicture/ptici/ara_g6ebhn.jpg");
            this.productRepository.save(productEntity);

            // grizachi
            productEntity = new ProductEntity()
                    .setName("Petya")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.FEMALE)
                    .setBreed("Zaiche")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677508/initPicture/animalias/zaiche2_all6wk.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Slavi")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Morski svinche")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677508/initPicture/animalias/morski_svinche_lfxbcq.jpg");
            this.productRepository.save(productEntity);
            productEntity = new ProductEntity()
                    .setName("Niki")
                    .setBirthDate(LocalDate.of(2020,12,12))
                    .setPrice(BigDecimal.valueOf(122.5))
                    .setGender(GenderEnum.MALES)
                    .setBreed("Zaiche")

                    .setImgUrl("https://res.cloudinary.com/dtijhevtf/image/upload/v1616677508/initPicture/animalias/zaiche1_x1zre0.jpg");
            this.productRepository.save(productEntity);


        }//end of if count
    }



}
