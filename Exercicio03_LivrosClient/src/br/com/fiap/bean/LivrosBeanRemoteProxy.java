package br.com.fiap.bean;

public class LivrosBeanRemoteProxy implements br.com.fiap.bean.LivrosBeanRemote {
  private String _endpoint = null;
  private br.com.fiap.bean.LivrosBeanRemote livrosBeanRemote = null;
  
  public LivrosBeanRemoteProxy() {
    _initLivrosBeanRemoteProxy();
  }
  
  public LivrosBeanRemoteProxy(String endpoint) {
    _endpoint = endpoint;
    _initLivrosBeanRemoteProxy();
  }
  
  private void _initLivrosBeanRemoteProxy() {
    try {
      livrosBeanRemote = (new br.com.fiap.bean.LivroEndPointLocator()).getLivrosBeanPort();
      if (livrosBeanRemote != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)livrosBeanRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)livrosBeanRemote)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (livrosBeanRemote != null)
      ((javax.xml.rpc.Stub)livrosBeanRemote)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.bean.LivrosBeanRemote getLivrosBeanRemote() {
    if (livrosBeanRemote == null)
      _initLivrosBeanRemoteProxy();
    return livrosBeanRemote;
  }
  
  public void add(br.com.fiap.bean.Livros livro) throws java.rmi.RemoteException{
    if (livrosBeanRemote == null)
      _initLivrosBeanRemoteProxy();
    livrosBeanRemote.add(livro);
  }
  
  public br.com.fiap.bean.Livros[] getAll() throws java.rmi.RemoteException{
    if (livrosBeanRemote == null)
      _initLivrosBeanRemoteProxy();
    return livrosBeanRemote.getAll();
  }
  
  
}