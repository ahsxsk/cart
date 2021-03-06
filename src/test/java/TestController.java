import com.alibaba.fastjson.JSON;
import com.shike.controller.CartController;
import com.shike.vo.CartAddParam;
import com.shike.vo.CartDelParam;
import com.shike.vo.CartEditParam;
import com.shike.vo.CartQuery;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shike on 16/3/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:applicationContext.xml"))
public class TestController {
    private static final Logger logger = Logger.getLogger(TestController.class);

    @Resource
    private CartController cartController;
//    @org.junit.Test
//    public void testQuery() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        try {
//            CartQuery cartQuery = new CartQuery();
//            cartQuery.setCartId("201603302225374181102200000012");
//            String cart = JSON.toJSONString(cartQuery);
//            request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
//            request.setMethod("POST");
//            request.setParameter("cartQuery", cart);
//            cartController.getCart(request,response);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
//
//    @Test
//    public void testList() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        try {
//            CartQuery cartQuery = new CartQuery();
//            cartQuery.setUserId("user00001");
//            cartQuery.setStatus(0);
//            String cart = JSON.toJSONString(cartQuery);
//            request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
//            request.setMethod("POST");
//            request.setParameter("cartQuery", cart);
//            cartController.getAll(request,response);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }

//    @Test
//    public void testEdit() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        try {
//            request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
//            request.setMethod("POST");
//            CartEditParam cartEditParam = new CartEditParam();
//            cartEditParam.setCartId("201605032009255340000110223123");
//            cartEditParam.setAmount(8);
//            String cart = JSON.toJSONString(cartEditParam);
//            request.setParameter("cartEditParam", cart);
//            cartController.editSkuAmount(request,response);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }

//    @Test
//    public void testAdd() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        MockHttpServletResponse response = new MockHttpServletResponse();
//        try {
//            request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
//            request.setMethod("POST");
//            CartAddParam cartAddParam = new CartAddParam();
//            cartAddParam.setUserId("TUE12131231");
//            cartAddParam.setSkuId("sku0011");
//            cartAddParam.setStatus(0);
//            cartAddParam.setShopId("shop0002");
//            cartAddParam.setPrice(1000);
//            cartAddParam.setAmount(1);
//            String cart = JSON.toJSONString(cartAddParam);
//            request.setParameter("cartAddParam", cart);
//            cartController.addCart(request,response);
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//    }

    @Test
    public void testDel() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        try {
            request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING,true);
            request.setMethod("POST");
            List<CartDelParam> carts = new ArrayList<CartDelParam>();
            CartDelParam cartDelParam = new CartDelParam();
            cartDelParam.setCartId("201605032009255340000110223123");
            cartDelParam.setUserId("TUE12131231");
            carts.add(cartDelParam);
            String str = JSON.toJSONString(carts);
            request.setParameter("cartDelParams", str);

            cartController.deleteCart(request,response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
