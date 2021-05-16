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
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService{

	private static final Logger log = LoggerFactory.getLogger(TipoIdentificacionServiceImpl.class);

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(TipoIdentificacion tipoIdentificacion)throws Exception{		
		 try {
			Set<ConstraintViolation<TipoIdentificacion>> constraintViolations =validator.validate(tipoIdentificacion);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<TipoIdentificacion> constraintViolation : constraintViolations) {
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
	 	return tipoIdentificacionRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoIdentificacion> findAll(){
		log.debug("finding all TipoIdentificacion instances");
       	return tipoIdentificacionRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public TipoIdentificacion save(TipoIdentificacion entity) throws Exception {
		log.debug("saving TipoIdentificacion instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("TipoIdentificacion");
		}
		
		validate(entity);	
	
//		if(tipoIdentificacionRepository.findById(entity.getIdTipoIdentificacion()).isPresent()){
//           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//        }    
	
	    return tipoIdentificacionRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save TipoIdentificacion failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(TipoIdentificacion entity) throws Exception {
            	log.debug("deleting TipoIdentificacion instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("TipoIdentificacion");
	    		}
    	
                                if(entity.getIdTipoIdentificacion()==null){
                    throw new ZMessManager().new EmptyFieldException("idTipoIdentificacion");
                    }
                        
            	            findById(entity.getIdTipoIdentificacion()).ifPresent(entidad->{	            	
	                													List<Cliente> clientes = entidad.getClientes();
							                    if(Utilities.validationsList(clientes)==true){
                       	 	throw new ZMessManager().new DeletingException("clientes");
                        }
	                	            });
                       

            try {
            
            tipoIdentificacionRepository.deleteById(entity.getIdTipoIdentificacion());
            log.debug("delete TipoIdentificacion successful");
            
            } catch (Exception e) {
            	log.error("delete TipoIdentificacion failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Long id) throws Exception {            
            	log.debug("deleting TipoIdentificacion instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("idTipoIdentificacion");
            	}
            	if(tipoIdentificacionRepository.findById(id).isPresent()){
           			delete(tipoIdentificacionRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public TipoIdentificacion update(TipoIdentificacion entity) throws Exception {

				log.debug("updating TipoIdentificacion instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("TipoIdentificacion");
		    		}
		    		
	            validate(entity);
	
	            return tipoIdentificacionRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update TipoIdentificacion failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<TipoIdentificacion> findById(Long idTipoIdentificacion) throws Exception {            
            	log.debug("getting TipoIdentificacion instance");
            	return tipoIdentificacionRepository.findById(idTipoIdentificacion);
            }
			
}
