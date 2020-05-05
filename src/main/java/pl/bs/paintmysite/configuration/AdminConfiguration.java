package pl.bs.paintmysite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bs.paintmysite.models.Category;
import pl.bs.paintmysite.models.Photo;
import pl.bs.paintmysite.models.Project;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.repositories.CategoryRepository;
import pl.bs.paintmysite.repositories.PhotoRepository;
import pl.bs.paintmysite.repositories.ProjectRepository;
import pl.bs.paintmysite.repositories.UserRepository;

import java.util.ArrayList;

@Configuration
public class AdminConfiguration {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProjectRepository projectRepository;
    private final PhotoRepository photoRepository;

    public AdminConfiguration(UserRepository userRepository, CategoryRepository categoryRepository, ProjectRepository projectRepository, PhotoRepository photoRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.projectRepository = projectRepository;
        this.photoRepository = photoRepository;
    }

    @Bean
    public void configureAdminAccount() {
        userRepository.save(createAdmin());
        createCategory();
        createProject();
        craetePhoto();
    }

    private void craetePhoto() {
        Photo photo = new Photo();
        photo.setUrl("https://lh3.googleusercontent.com/cn0D3CJ9yCh19rlpRGDpc3Y321gNb6JM4O1pi5kBEBytrXezJ3VajlXgHMKR4I69D64Wk6sERNd2cuYqSTVkWbSPn28-rs8vrggX4cc1SiDNlhkpSoWne5KgwXMddOl5k1GZ3HEpDuT-sdIFoWBpWBpcq9eCc-AljojeXHuDeykAKytnYdasSLg426gLgb42yKeV5U0tGqPOzqIS7cIVIpbUPXe2JFBT--ztNUwG0vZtJ0cWirqMMyWil5MmuWEOhj73--d1CdeMmSAKkMdY1JfC6bIOA0M9Pfs6TS8HUd0qudPG4DkyEBMM0ikTdMinvN43VLqf6iu-3MPCX2p1nAKwgvWPfavP7hPU_HTBDegM2qAcL9_9qUBEnA7vap2pUSXA3oJMeRx0z1Yt2w9oRQNhy4GF-nkPl7PvAS7vJWlAnroAZaSt3t_DLFCwYMEVDTDi6Nq6l--TSSzEhwGG25MWJEQlTrswBvypiccRPEpqWRW_KhwlcdoZ86-wNRFZiJD-ePuZ443zv2iNlBVl8J6v6HPLyhFZ6dJwCAWBhxYHsOUjd0muIT3YHIJNnPiBrWlr1pHLRAcE0HXJrC8hGCXOyjJbB9kQhM3Cm25slu4Iea3WYF1hb-JVoh4NG5MuUe_3EJOs3VR6yn38gVIjD_boz2NPkZprGDUrqoIeyL4XdU_Nfdy9IAXKD1o6vw=w1396-h785-no");
        photo.setOrderInProject(1);
        photo.setProjectId(1L);
        photo.setId(1L);
        photoRepository.save(photo);
        photo.setUrl("https://lh3.googleusercontent.com/jdDQ1F7oAlrk5aAt7SVDh2_AX1HPwQcVVTINcZ4RPDwYRprvVRxQOVjCaVV_fw92Pv6Q8BCPJRu40XZPw4tzE9mH7exPvakL1jzYCFNdG0zC6_4aUdYuIYJD0RFipRk_zqOZ_m3_dX-boNdg2k7abaXMdbhD33qr4QLbdyK_5_H_2ClPKzf05FzDQkrznyV3PuFyx1toIbxP3Fyng7aqinn_rKnU4HL9gONs5aW_X0LuzK1kjHpCN0B6gIsDxlvRd0tlQwdjEITVGjjLT-_9ctgBkj6g-9vjTE0Sg_Nnq1oVSie8LaydsexNai7BBUIE5sqPCR755GxqM-0F4kkIoZhR0uZM9csbvDoM6w_XvWyAe3ATJrnItcy4gVc2j6HrnSi6PIeoCMB2cOl7pt33NHFdC80HoEAnVH-xNr9A_FInV6Y4iYnqxfT_CC8jV_NifbmBSlR195JnB_rHxhlYoq6UkF2gIcb8sDO8wZ-ikyC4e0qFouqFnUgLt_n0xgTPRGbb6IhKAZZpzuyuDEA5rR05MRvDcw0ojRPS8dD1TV0lZ5OUewobG9e6gJTL8Qb0JjPbEtHRe98vl2zDLhJUUiOBfSJHTxRU6eLXEbPwmfwYeH_Qj5x2BCqvP6d3KECHBCNs-Hd0xt7ODVI7_Q6x9rsA_m335m7eUZMZ2LP37U4vLgKlsWjAfP2VuQIjkA=w1396-h785-no");
        photo.setOrderInProject(1);
        photo.setProjectId(2L);
        photo.setId(2L);
        photoRepository.save(photo);
        photo.setUrl("https://lh3.googleusercontent.com/dHr4dntaV8GO2utf7KJlB4LZFD6nL4y7BV887Ol219ljvXogyd4_QJ1Ez39nV0hnkIHbR9B2KylNG1_tiwBgAonvo3SKYvE6rHW_ln5N3S1h3sHARVb2GDX6RouoBwTUXPXUTPYcscFDnxZKoxhDj62lZpuajne0bqusy1zbYJwzWZ9ODqem1eUh-M1DOqDlyzNFwGQgELM8gM-_ffPtT4F8NZOGnLl_OuGZ4dOdYVU59nfdCqCweAUkVgH6DusSEr3wP0p6e16hoLOTTItqcD_aJGJRCUjs6uavcwyFxsZGQ6loI3HUxSWpP_GYhxfpu7MgcsI0Kd5qzRqklkNCdDQOW7QUsQNVcM9-f4MB6CwAU4D_uOVs25wnAj7gqnTGqnRY9nxjmBIPcDmL2hPAgNQZUW3clLMO88ZiNEpnUpGhW_8M9boNRYNNtb86o6AT8wJtL0chj8hTM_17EQ6RL1h1L95jIPl0w5cwyVw3CaPKE-CByxZRafBulf1qcLIx5yE-zEcLuOn-iBcNUuWGGr6dYH5HFuceLOqjk-SmjdEYrMEEcgwSIvDP8nbY6NURlhqZgOJnhfqSrB_cSdggq0uzQVuZ49keVS3BLZuNDFA1QrzjOg_xHzMsT465ayXgHmJTHLhIaSt_SVU4LKndjs0KTs-bVxykhB1Ht018gUYeZKIxYU6Bf2avVlyeUw=w1178-h785-no");
        photo.setOrderInProject(1);
        photo.setProjectId(3L);
        photo.setId(3L);
        photoRepository.save(photo);
        photo.setUrl("https://lh3.googleusercontent.com/Cv6DBU9iM9ZQ9bmqWUfqh9_zoNPA3yw-3aza0606riTCrmF74ONDX8h9u-hA97t32y-lpIM3w1XaM77WoccjInDCnfkJoPXu-0G-R31b7vT8N9I5s_TfhBZRh_0t91bgAZkwb-L_O-44UVdsZ2bIbIpZijr6ogXURBoP4yqkL5ua3dkwNx0U4ciZKNVXku5613Wj1ItaUuamVW-kJAMKKSyxpakRz_qHljlKBKf-_1lGBrD-v6oO03iy8U9MWJJp3Fg0rWsYyAeZ4GEwHeScUdKkwkWgpxsrQSi2iU5rCS9ugjCOG-XmlQns-dN_YDY6NzVj-6F1X6zHlm5OBPChnmR2BFr2OU8YiZgHR2uDcp6vp3OAeuvE3LTf_MvxDI0ElYHNwVhJ4t4Uk3PivQNyfPtN04DVQ4COhOvcbO1iN15Zz_vhkwHgjiMrpO56bIZf2AWmW5V2p35F64n93uvDWwcAdC73ucCuMu89FFz3PZeeXn2MtystzZDKsqGraiYKkJ_1L8x3FYVbdci7v-PcXHldEEHepOsjudxyb2AD5oAQMrKBPcOZHpL7qiLXAz0_F0mBoMgIjXM3vpe7OCf0IfOYx0Voxkn1ZEmctmnHNaz6pDhmCpH-jMgUOl7w-R89hkBFSh4-hITKwLHnywO7xNwSt2CnprJGNvns-Olcv5CNzXAnryqXThYRUCB5Ig=w492-h273-no");
        photo.setOrderInProject(1);
        photo.setProjectId(4L);
        photo.setId(4L);
        photoRepository.save(photo);
    }

    private void createProject() {
        Project project = new Project();
        project.setName("Shin Lim Deck v2");
        project.setDescription("New deck of cards designed for a magician.");
        project.setCategoryId(3L);
        project.setId(1L);
        project.setPhotos(new ArrayList<>());
        projectRepository.save(project);
        project.setName("Saint Martins");
        project.setDescription("Landscape showing sunset and chillout.");
        project.setCategoryId(2L);
        project.setId(2L);
        project.setPhotos(new ArrayList<>());
        projectRepository.save(project);
        project.setName("Man in woods");
        project.setDescription("Abstract painting...");
        project.setCategoryId(2L);
        project.setId(3L);
        project.setPhotos(new ArrayList<>());
        projectRepository.save(project);
        project.setName("Business card");
        project.setDescription("Business card for architect");
        project.setCategoryId(1L);
        project.setId(4L);
        project.setPhotos(new ArrayList<>());
        projectRepository.save(project);
    }

    private void createCategory() {
        Category category = new Category();
        category.setName("Architecture");
        category.setDescription("Designing buildings and much more...");
        category.setProjects(new ArrayList<>());
        category.setPhotoUrl("");
        category.setId(1L);
        categoryRepository.save(category);
        category.setName("Paintings");
        category.setDescription("Portraits, landscapes, art...");
        category.setProjects(new ArrayList<>());
        category.setPhotoUrl("");
        category.setId(2L);
        categoryRepository.save(category);
        category.setName("Other");
        category.setDescription("Everything else...");
        category.setProjects(new ArrayList<>());
        category.setPhotoUrl("");
        category.setId(3L);
        categoryRepository.save(category);
    }

    private User createAdmin() {
        User user = new User();
        user.setId(0L);
        user.setName("Marta");
        user.setSurname("Szczepańczyk");
        user.setJobTitle("Architect / Graphic designer / Artist / Painter");
        user.setAboutMe("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate arcu, vel tempus metus leo non est. Etiam sit amet lectus quis est congue mollis. Phasellus congue lacus eget neque. Phasellus ornare, ante vitae consectetuer consequat, purus sapien ultricies dolor, et mollis pede metus eget nisi. Praesent sodales velit quis augue. Cras suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in interdum massa nibh nec erat.");
        user.setEmail("theterabit@gmail.com");
        user.setPhoneNumber("123456789");
        user.setProfilePictureUrl("https://scontent-waw1-1.xx.fbcdn.net/v/t1.0-9/p960x960/76747498_2410765555718521_9194958319930834944_o.jpg?_nc_cat=110&_nc_sid=85a577&_nc_ohc=VRMdNi7OTQAAX_Ju-yS&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=819a4232585ffd07742fdf9a9472bf64&oe=5ED5D321");

        return user;
    }

}
