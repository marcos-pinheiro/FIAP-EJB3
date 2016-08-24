/**
 * LivroEndPointLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.bean;

public class LivroEndPointLocator extends org.apache.axis.client.Service implements br.com.fiap.bean.LivroEndPoint {

    public LivroEndPointLocator() {
    }


    public LivroEndPointLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LivroEndPointLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LivrosBeanPort
    private java.lang.String LivrosBeanPort_address = "http://localhost:8080/Exercicio03_LivrosWS/LivroEndPoint/LivrosBean";

    public java.lang.String getLivrosBeanPortAddress() {
        return LivrosBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LivrosBeanPortWSDDServiceName = "LivrosBeanPort";

    public java.lang.String getLivrosBeanPortWSDDServiceName() {
        return LivrosBeanPortWSDDServiceName;
    }

    public void setLivrosBeanPortWSDDServiceName(java.lang.String name) {
        LivrosBeanPortWSDDServiceName = name;
    }

    public br.com.fiap.bean.LivrosBeanRemote getLivrosBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LivrosBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLivrosBeanPort(endpoint);
    }

    public br.com.fiap.bean.LivrosBeanRemote getLivrosBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.bean.LivroEndPointSoapBindingStub _stub = new br.com.fiap.bean.LivroEndPointSoapBindingStub(portAddress, this);
            _stub.setPortName(getLivrosBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLivrosBeanPortEndpointAddress(java.lang.String address) {
        LivrosBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.bean.LivrosBeanRemote.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.bean.LivroEndPointSoapBindingStub _stub = new br.com.fiap.bean.LivroEndPointSoapBindingStub(new java.net.URL(LivrosBeanPort_address), this);
                _stub.setPortName(getLivrosBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LivrosBeanPort".equals(inputPortName)) {
            return getLivrosBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://bean.fiap.com.br/", "LivroEndPoint");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://bean.fiap.com.br/", "LivrosBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LivrosBeanPort".equals(portName)) {
            setLivrosBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
