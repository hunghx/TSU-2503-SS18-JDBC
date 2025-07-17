package ra.project.presentation;

import ra.project.business.dao.CategoryDaoImpl;
import ra.project.business.service.CategoryServiceImpl;
import ra.project.business.service.IProductService;
import ra.project.business.service.ProductServiceImpl;

import java.util.Scanner;

public class EcommeceApplication {
    private static CategoryServiceImpl categoryService = new CategoryServiceImpl();
    private static IProductService productService = new ProductServiceImpl();
    public static void main(String[] args) {
        run();
    }
    private static void run(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n" +
                    "********************PRODUCT MANAGEMENT****************\n" +
                    "1. Danh sách sản phẩm\n" +
                    "2. Thêm mới sản phẩm\n" +
                    "3. Cập nhật sản phẩm\n" +
                    "4. Xóa sản phẩm\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm\n" +
                    "6. Sắp xếp sản phẩm theo giá tăng dần\n" +
                    "7. Thống kê số lượng sản phẩm theo danh mục\n" +
                    "8. Thoát");
            System.out.println("Nhạp lựa chọn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 7:
                    productService.displayCountProductGroupByCategory();
                    break;
            }
        }
    }
}
