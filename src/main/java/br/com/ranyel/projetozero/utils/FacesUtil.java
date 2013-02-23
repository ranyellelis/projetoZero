package br.com.ranyel.projetozero.utils;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class FacesUtil.
 */
public abstract class FacesUtil {

    /**
     * Método FacesContext getFacesContext() responsavel por recuperar FacesContext.
     * 
     * @return FacesContext.
     */
    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Método ExternalContext getExternalContext() responsavel por recuperar ExternalContext.
     * 
     * @return ExternalContext.
     */
    public static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    /**
     * Método ServletContext getServletContext() responsavel por recuperar ServletContext.
     * 
     * @return ServletContext.
     */
    public static ServletContext getServletContext() {
        return (ServletContext) getExternalContext().getContext();
    }

    /**
     * Método HttpSession getHttpSession() responsavel por recuperar HttpSession.
     * 
     * @return HttpSession.
     */
    public static HttpSession getHttpSession() {
        return (HttpSession) getExternalContext().getSession(false);
    }

    /**
     * Método HttpServletRequest getHttpServletRequest() responsavel por recuperar HttpServletRequest.
     * 
     * @return HttpServletRequest.
     */
    public static HttpServletRequest getHttpServletRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    /**
     * Método HttpServletResponse getHttpServletResponse() responsavel por recuperar HttpServletResponse.
     * 
     * @return HttpServletResponse.
     */
    public static HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) getExternalContext().getResponse();
    }

    /**
     * Adds the info message.
     * 
     * @param msg the msg.
     */
    public static void addInfoMessage(final String msg) {
        addInfoMessage(null, msg);
    }

    /**
     * Adds the info message.
     * 
     * @param clientId the client id.
     * @param msg the msg.
     */
    public static void addInfoMessage(final String clientId, final String msg) {
        getFacesContext().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    /**
     * Adds the info message from bundle.
     * 
     * @param clientId the client id.
     * @param key the key.
     * @param params the params.
     */
    public static void addInfoMessageFromBundle(final String clientId, final String key, final String... params) {
        addInfoMessage(clientId, getMessage(key, params));
    }

    /**
     * Adds the error message.
     * 
     * @param msg the msg.
     */
    public static void addErrorMessage(final String msg) {
        addErrorMessage(null, msg);
    }


    /**
     * Adds the error message.
     * 
     * @param clientId the client id.
     * @param msg the msg.
     */
    public static void addErrorMessage(String clientId, String msg) {
        getFacesContext().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
    }

    /**
     * Adds the error message from bundle.
     * 
     * @param clientId the client id.
     * @param key the key.
     * @param params the params.
     */
    public static void addErrorMessageFromBundle(String clientId, String key, String... params) {
        addErrorMessage(clientId, getMessage(key, params));
    }


    /**
     * Adds the warn message.
     * 
     * @param msg the msg.
     */
    public static void addWarnMessage(String msg) {
        addWarnMessage(null, msg);
    }

    /**
     * Adds the warn message.
     * 
     * @param clientId the client id.
     * @param msg the msg.
     */
    public static void addWarnMessage(String clientId, String msg) {
        getFacesContext().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
    }

    /**
     * Adds the warn message from bundle.
     * 
     * @param clientId  the client id.
     * @param key the key.
     * @param params the params.
     */
    public static void addWarnMessageFromBundle(String clientId, String key, String... params) {
        addWarnMessage(null, getMessage(key, params));
    }

    /**
     * Método ResourceBundle getResourceBundle() responsavel por recuperar ResourceBundle.
     * @return ResourceBundle.
     */
    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle(getFacesContext().getApplication().getMessageBundle());
    }

    /**
     * Método String getMessage(String key) responsavel por recuperar Message.
     * 
     * @param key the key.
     * @return Message.
     */
    public static String getMessage(String key) {
        return getResourceBundle().getString(key);
    }

    /**
     * Método String getMessage(String key, String[] params) responsavel por recuperar Message.
     * 
     * @param key the key.
     * @param params the params.
     * @return Message.
     */
    public static String getMessage(String key, String... params) {
        MessageFormat form = new MessageFormat(getResourceBundle().getString(key));
        return form.format(params);
    }

    /**
     * Redirect.
     * 
     * @param url the url.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void redirect(String url) throws IOException {
        String serverName = getHttpServletRequest().getServerName();
        getHttpServletResponse().sendRedirect("http://" + serverName + "/" + url);
    }
}