package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.*;
import controller.admin.AdminNewController;
import controller.admin.DeleteProductController;
import controller.admin.InsertProductController;
import controller.admin.updateProductController;
import controller.member.AddProductToCartController;
import controller.member.CartListController;
import controller.member.LoginController;
import controller.member.LogoutController;
import controller.member.MyOrderController;
import controller.member.MyOrderViewController;
import controller.member.RegisterUserController;
import controller.member.UpdateMyInfoController;
import controller.member.myPageController;
import controller.product.OrderController;
import controller.product.ProductListController;
import controller.product.ReviewController;
import controller.product.surveyController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/main", new ForwardController("/Main.jsp"));
    	
    	mappings.put("/user/login/form", new ForwardController("/user/loginForm.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
        mappings.put("/review/form", new ForwardController("/review/reviewform2.jsp"));
        mappings.put("/review/main", new ForwardController("/review/review.jsp"));

        mappings.put("/review/create", new ReviewController());
        mappings.put("/user/register", new RegisterUserController());
        mappings.put("/user/mypage/form", new myPageController());
        mappings.put("/user/update", new UpdateMyInfoController());
        
        mappings.put("/user/myorder/list", new MyOrderController());
        mappings.put("/user/myorderList", new ForwardController("/user/myorderList.jsp"));
        mappings.put("/user/myorder/view", new MyOrderViewController());
        mappings.put("/user/myorderView", new ForwardController("/user/myorderView.jsp"));
        
        mappings.put("/cart/addProduct", new AddProductToCartController());
        mappings.put("/cart/cartList", new CartListController());
        mappings.put("/cart/cart", new ForwardController("/cart/Cart.jsp"));
        mappings.put("/cart/result", new ForwardController("/cart/AddItemToCartResult.jsp"));
        
        mappings.put("/survey", new ForwardController("/survey/surveyMain.jsp"));
        mappings.put("/survey/main", new ForwardController("/survey/mainprocess.jsp"));
        mappings.put("/survey/result", new surveyController());
        
        mappings.put("/product/category", new ForwardController("/product/Category.jsp"));
        mappings.put("/product/list", new ProductListController());
        
        mappings.put("/order", new ForwardController("/product/orderForm.jsp"));
        mappings.put("/order/ordercont", new OrderController());
        
        mappings.put("/admin", new ForwardController("/admin/admin_main.jsp"));
        mappings.put("/admin/add", new ForwardController("/admin/addProduct.jsp"));
        mappings.put("/admin/update", new ForwardController("/admin/updateProduct.jsp"));
        mappings.put("/admin/delete", new ForwardController("/admin/deleteProduct.jsp"));
        mappings.put("/admin/add/cont", new InsertProductController());
        mappings.put("/admin/update/cont", new updateProductController());
        mappings.put("/admin/delete/cont", new DeleteProductController());
        
        
        //mappings.put("/review", new ForwardController("리뷰.jsp"));

        //mappings.put("/survey/result", new surveyController());
        //mappings.put("/product", new productListController());
        
        //mappings.put("/survey/result", new ForwardController("/survey/surveyResult.jsp"));
        //mappings.put("/user/delete", new DeleteUserController());  만들기!!!
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}
