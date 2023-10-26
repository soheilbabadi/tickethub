package cloud.tickethub.theventservice.event.service;

import cloud.tickethub.theventservice.event.domain.Category;
import cloud.tickethub.theventservice.event.infra.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class ApplicationRunner implements CommandLineRunner {


    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category();


        category.setTitle("تکنولوژی");
        category.setDescription("تکنولوژی");
        categoryRepo.save(category);

        Category category2 = new Category();
        category2.setTitle("پیشرفت شخصی");
        category2.setDescription("پیشرفت شخصی");
        categoryRepo.save(category2);

        Category category3 = new Category();
        category3.setTitle("کارآفرینی");
        category3.setDescription("کارآفرینی");
        categoryRepo.save(category3);

        Category category4 = new Category();
        category4.setTitle("مدیریت");
        category4.setDescription("مدیریت");
        categoryRepo.save(category4);

        Category category5 = new Category();
        category5.setTitle("توسعه فردی");
        category5.setDescription("توسعه فردی");
        categoryRepo.save(category5);

        Category category6 = new Category();
        category6.setTitle("هنری");
        category6.setDescription("هنری");
        categoryRepo.save(category6);

        Category category7 = new Category();
        category7.setTitle("ورزشی");
        category7.setDescription("ورزشی");
        categoryRepo.save(category7);

        Category category8 = new Category();
        category8.setTitle("سلامت جسم و روح");
        category8.setDescription("سلامت جسم و روح");
        categoryRepo.save(category8);

        Category category9 = new Category();
        category9.setTitle("سایر");
        category9.setDescription("سایر");
        categoryRepo.save(category9);


    }
}
