package  com.nuvu.clientes.service;


import java.math.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.nuvu.clientes.exception.*;
import com.nuvu.clientes.repository.*;
import com.nuvu.clientes.utility.Utilities;

import com.nuvu.clientes.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService{

	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Cliente cliente)throws Exception{		
		 try {
			Set<ConstraintViolation<Cliente>> constraintViolations =validator.validate(cliente);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<Cliente> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}
				 throw new Exception(strMessage.toString());
			 }
		 }catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return clienteRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll(){
		log.debug("finding all Cliente instances");
       	return clienteRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public Cliente save(Cliente entity) throws Exception {
		log.debug("saving Cliente instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Cliente");
		}
		
		validate(entity);	
	
//		if(clienteRepository.findById(entity.getIdCliente()).isPresent()){
//           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//        }    
	
	    return clienteRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save Cliente failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(Cliente entity) throws Exception {
            	log.debug("deleting Cliente instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Cliente");
	    		}
    	
                                if(entity.getIdCliente()==null){
                    throw new ZMessManager().new EmptyFieldException("idCliente");
                    }
                        
            	            findById(entity.getIdCliente()).ifPresent(entidad->{	            	
	                													List<TarjetaCliente> tarjetaClientes = entidad.getTarjetaClientes();
							                    if(Utilities.validationsList(tarjetaClientes)==true){
                       	 	throw new ZMessManager().new DeletingException("tarjetaClientes");
                        }
	                	            });
                       

            try {
            
            clienteRepository.deleteById(entity.getIdCliente());
            log.debug("delete Cliente successful");
            
            } catch (Exception e) {
            	log.error("delete Cliente failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Long id) throws Exception {            
            	log.debug("deleting Cliente instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idCliente");
            	}
            	if(clienteRepository.findById(id).isPresent()){
           			delete(clienteRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public Cliente update(Cliente entity) throws Exception {

				log.debug("updating Cliente instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Cliente");
		    		}
		    		
	            validate(entity);
	
	            return clienteRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update Cliente failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Cliente> findById(Long idCliente) throws Exception {            
            	log.debug("getting Cliente instance");
            	return clienteRepository.findById(idCliente);
            }
			
}
