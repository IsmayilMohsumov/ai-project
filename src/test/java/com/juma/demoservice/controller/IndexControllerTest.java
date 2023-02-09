package com.juma.demoservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;

@ContextConfiguration(classes = {IndexController.class})
@ExtendWith(SpringExtension.class)
class IndexControllerTest {
    @Autowired
    private IndexController indexController;

    /**
     * Method under test: {@link IndexController#start(org.springframework.ui.Model)}
     */
    @Test
    void testStart() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [start]: would dispatch back to the current handler URL [/start] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:210)
        //       at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:148)
        //       at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:316)
        //       at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1393)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.render(TestDispatcherServlet.java:137)
        //       at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1138)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1077)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent start(Model)
        //   from throwing ServletException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   start(Model).
        //   See https://diff.blue/R013 to resolve this issue.

        IndexController indexController = new IndexController();
        assertEquals("start", indexController.start(new ConcurrentModel()));
    }

    /**
     * Method under test: {@link IndexController#about(org.springframework.ui.Model)}
     */
    @Test
    void testAbout() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/about");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("about-us"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("about-us"));
    }

    /**
     * Method under test: {@link IndexController#register()}
     */
    @Test
    void testRegister() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [register]: would dispatch back to the current handler URL [/register] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:210)
        //       at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:148)
        //       at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:316)
        //       at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1393)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.render(TestDispatcherServlet.java:137)
        //       at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1138)
        //       at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1077)
        //       at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962)
        //       at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
        //       at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:626)
        //       at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
        //       at org.springframework.test.web.servlet.TestDispatcherServlet.service(TestDispatcherServlet.java:72)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
        //       at org.springframework.mock.web.MockFilterChain$ServletFilterProxy.doFilter(MockFilterChain.java:167)
        //       at org.springframework.mock.web.MockFilterChain.doFilter(MockFilterChain.java:134)
        //       at org.springframework.test.web.servlet.MockMvc.perform(MockMvc.java:183)
        //   In order to prevent register()
        //   from throwing ServletException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   register().
        //   See https://diff.blue/R013 to resolve this issue.

        assertEquals("register", (new IndexController()).register());
    }

    /**
     * Method under test: {@link IndexController#about(org.springframework.ui.Model)}
     */
    @Test
    void testAbout2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/about", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("about-us"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("about-us"));
    }

    /**
     * Method under test: {@link IndexController#index(javax.servlet.http.HttpSession)}
     */
    @Test
    void testIndex() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    /**
     * Method under test: {@link IndexController#index(javax.servlet.http.HttpSession)}
     */
    @Test
    void testIndex2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("index"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("index"));
    }

    /**
     * Method under test: {@link IndexController#labelDetection(org.springframework.ui.Model)}
     */
    @Test
    void testLabelDetection() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/label");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("label-detection"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("label-detection"));
    }

    /**
     * Method under test: {@link IndexController#labelDetection(org.springframework.ui.Model)}
     */
    @Test
    void testLabelDetection2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/label");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("label-detection"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("label-detection"));
    }

    /**
     * Method under test: {@link IndexController#landmarkDetection(org.springframework.ui.Model)}
     */
    @Test
    void testLandmarkDetection() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/landmark");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("landmark-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("landmark-page"));
    }

    /**
     * Method under test: {@link IndexController#landmarkDetection(org.springframework.ui.Model)}
     */
    @Test
    void testLandmarkDetection2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/landmark");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("landmark-page"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("landmark-page"));
    }

    /**
     * Method under test: {@link IndexController#login(org.springframework.ui.Model)}
     */
    @Test
    void testLogin() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/index");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("users"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("users"));
    }

    /**
     * Method under test: {@link IndexController#login(org.springframework.ui.Model)}
     */
    @Test
    void testLogin2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/index");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("users"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("users"));
    }

    /**
     * Method under test: {@link IndexController#logout(javax.servlet.http.HttpSession)}
     */
    @Test
    void testLogout() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/logout");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/login"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    /**
     * Method under test: {@link IndexController#logout(javax.servlet.http.HttpSession)}
     */
    @Test
    void testLogout2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/logout");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/login"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    /**
     * Method under test: {@link IndexController#technologiesUsed(org.springframework.ui.Model)}
     */
    @Test
    void testTechnologiesUsed() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/technologies");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("technologies-used"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("technologies-used"));
    }

    /**
     * Method under test: {@link IndexController#technologiesUsed(org.springframework.ui.Model)}
     */
    @Test
    void testTechnologiesUsed2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/technologies");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("technologies-used"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("technologies-used"));
    }

    /**
     * Method under test: {@link IndexController#textDetection(org.springframework.ui.Model)}
     */
    @Test
    void testTextDetection() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/text");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("text-detection"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("text-detection"));
    }

    /**
     * Method under test: {@link IndexController#textDetection(org.springframework.ui.Model)}
     */
    @Test
    void testTextDetection2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/text");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.indexController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("text-detection"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("text-detection"));
    }
}

