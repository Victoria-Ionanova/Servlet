package by.iba.ionanova.servlet;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.iba.ionanova.servlet.constants.AuthConstants.LOGIN;
import static by.iba.ionanova.servlet.constants.AuthConstants.PASSWORD;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class ControllerTest {
    private static LoginServlet loginServlet;
    private static HttpServletRequest request;
    private static HttpServletResponse response;
    private static RequestDispatcher requestDispatcher;
    @Before
    public void setUp() throws Exception {
        loginServlet = new LoginServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
        initMocks(this);
    }

    @Ignore
    @Test
    public void loginServletWithOutParam() throws ServletException, IOException {
        // Arrange
        when(request.getParameter(LOGIN)).thenReturn("admin");
        when(request.getParameter(PASSWORD)).thenReturn("admin");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        // Act
        loginServlet.doPost(request, response);
        // Assert
        verify(request).setAttribute("errorMessage", "Неверный логин или пароль, заполните все поля");
        verify(requestDispatcher).forward(request, response);
    }
}
