/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import database.DAOCluster;
import database.DAOEntityRaw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author osboxes
 */
public class CEntityRaw {
    
    private String entityId; //To set the ID give each entity
    private String entityName;//To save the name of the entity. For example, Raul Castillo Castillo
    private String entityType;//To save the kind of entity. For example PER, LOC, ORG, OTH 
        
    public String getEntityId() {
        return entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public String getEntityType() {
        return entityType;
    }
    
   /* public List getEntitiesRawBelongCorpus(DAOCorpus corpusId)
    {
        EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();        
        
        Query query = em.createQuery("select er from DAOEntityRaw d where d.corpid=:corpusId");
        query.setParameter("corpusId", corpusId);
        List<DAOEntityRaw> resultList = query.getResultList();
        return resultList;   
    }    */
    
    public int deleteEntityById(EntityManager em, int entityId)
    {
        String queryText="delete from DAOEntityRaw e where e.entityid = :entityId";
        try
        {
            Query queryDelete=em.createQuery(queryText);

            queryDelete.setParameter("entityId", entityId);    

            int answer =queryDelete.executeUpdate();

            return answer;            
        }
        catch(Exception e)
        {
            throw e;
        }                
    }
    
    public int[] deleteEntityClusterById(EntityManager em, int entityId)
    {
        int[] answer={0,0};
        
        String deleteEntityCluster="delete from DAOEntityrawcluster e where e.dAOEntityrawclusterPK.entityid = :entityId";
        String deleteEntity="delete from DAOEntityRaw e where e.entityid = :entityId";
        try
        {
            Query queryDelete=em.createQuery(deleteEntityCluster);
            queryDelete.setParameter("entityId", entityId);    
            answer[0] =queryDelete.executeUpdate();
            
            System.out.println("Entity cluster borrado: " + answer[0]);
            
            queryDelete=em.createQuery(deleteEntity);
            queryDelete.setParameter("entityId", entityId);    
            answer[1] =queryDelete.executeUpdate();            
            
            System.out.println("Entity raw borrado: " + answer[1]);
            
        }
        catch(Exception e)
        {
            throw e;
        }           
        
        return answer;
    }    
    
    public void updateEntityType(EntityManager em, int entityId, String newType)
    {
        try
        {
            Query query = em.createNamedQuery("DAOEntityRaw.findByEntityid");
            query.setParameter("entityid", (Integer)entityId);
            DAOEntityRaw daoEntRaw=(DAOEntityRaw)query.getSingleResult();

            //String queryText="update DAOSentence s set s.sentencecontent=:updatedSentence where s.sentenceid = :sentenceId";

             //The begining of the transaction
            //em.getTransaction().begin();

            daoEntRaw.setEntitytype(newType);

            em.persist(daoEntRaw);            
        }
        catch(Exception e)
        {
            throw e;
        }           
    }    
    
    public int deleteSelectedEntities(HashSet<Integer> entitiesSet)
    {
        /*
        It receives a HashSet that contains a set of entities that the user
        wants to delete.
        */
        EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();                        
        
        String queryText="delete from DAOEntityRaw e where e.entityid in :entitiesId";
        
         //The begining of the transaction
        em.getTransaction().begin();
        
        Query queryDelete=em.createQuery(queryText);
        
        queryDelete.setParameter("entitiesId", entitiesSet);                
        
       
        
        int answer =queryDelete.executeUpdate();

        try
        {
            //Commiting the transaction
            em.getTransaction().commit();                    
        }
        catch(Exception e)
        {
            //Executing a rollback in case of error
            em.getTransaction().rollback();  
            answer=0;
        }        

        
        /*
        Iterator iter= entitiesSet.iterator();  
        
        //The begining of the transaction
        em.getTransaction().begin();
        
        while (iter.hasNext())
        {                                                
            //A query to delete entities
            Query query = em.createNativeQuery(queryText);
            //Getting the ID from the HashSet
            int entityId=(Integer)iter.next();
            //Setting the parameter used to find and to eliminate an entity
            query.setParameter(1, entityId);            
            //Saving changes
            em.persist(doc);
        }        
        try
        {
            //Commiting the transaction
            em.getTransaction().commit();                    
        }
        catch(Exception e)
        {
            //Executing a rollback in case of error
            em.getTransaction().rollback();  
            answer=false;
        }        

        
        return result;*/
        
        return answer;
        
    }
    
    public Set getEntitiesByCluster(int clusterId)
    {                
        EntityManager entityManager = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();
        Query query = entityManager.createNamedQuery("DAOCluster.findByClusterid");
        query.setParameter("clusterid", clusterId);
                
        DAOCluster cluster  = (DAOCluster)query.getSingleResult();        
        
        return cluster.getDAOEntityrawclusterSet();                
    }   
    
    public List<DAOEntityRaw> getEntitiesByCorpusId(EntityManager em, int corpusId)
    {
         String queryText="select " +
                        "e.ENTITYID,e.ENTITYNAME,e.ENTITYTYPE,e.SENTENCEID "+
                        "from " +
                        "CORPUS c, " +
                        "document d, " +
                        "sentence s, " +
                        "entityraw e " +
                        "where " +
                        "c.CORPID=?1 and " +
                        "c.CORPID=d.CORPID and " +
                        "d.DOCID=s.DOCID and " +
                       " s.SENTENCEID=e.SENTENCEID ";    
            
            Query query=em.createNativeQuery(queryText, DAOEntityRaw.class);
            
            query.setParameter(1, corpusId);
            
            List<DAOEntityRaw> entitiesRawList = query.getResultList();
            
            return entitiesRawList;
    }
    
   public List<Object[]> getEntitiesAndSentencesByCluster(int clusterId)
    {
        EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();        
            
        String queryText=   "select e.ENTITYID,e.ENTITYNAME,e.ENTITYTYPE,s.SENTENCEID,s.SENTENCECONTENT " +
                            "from " +
                            "snadb.entityraw e, " +
                            "snadb.cluster c, " +
                            "snadb.entityrawcluster ec, " +
                            "snadb.sentence s " +
                            "where " +
                            "c.CLUSTERID=? and " +
                            "ec.CLUSTERID=c.CLUSTERID and " +
                            "ec.ENTITYID=e.ENTITYID and " +
                            "e.SENTENCEID=s.SENTENCEID";
        
        Query query = em.createNativeQuery(queryText);
        query.setParameter(1, clusterId);
        List<Object[]> result= query.getResultList();
        
        return result;        
    }
   
   public Object[] getEntitiesAndSentencesByClusterAndEntity(int clusterId, int entityId)
   {
        EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();        
            
        String queryText=   "select e.ENTITYID,e.ENTITYNAME,e.ENTITYTYPE,s.SENTENCEID,s.SENTENCECONTENT " +
                            "from " +
                            "snadb.entityraw e, " +
                            "snadb.cluster c, " +
                            "snadb.entityrawcluster ec, " +
                            "snadb.sentence s " +
                            "where " +
                            "c.CLUSTERID=? and " +
                            "e.ENTITYID= ? and " +
                            "ec.CLUSTERID=c.CLUSTERID and " +
                            "ec.ENTITYID=e.ENTITYID and " +
                            "e.SENTENCEID=s.SENTENCEID";
        
        Query query = em.createNativeQuery(queryText);
        query.setParameter(1, clusterId);
        query.setParameter(2, entityId);
        Object[] result= (Object[])query.getSingleResult();
        
        return result;               
   }
   
   public void updateEntitiesClusterByHand(EntityManager em, HashSet<Integer> entitiesToCreateNewCluster, int oldClusterId, int newClusterId)
   {
       //Obtengo el objeto cluster que quiero modificar
       /*Query query=em.createNamedQuery("DAOCluster.findByClusterid");
       query.setParameter("clusterid", oldClusterId);
       DAOCluster clusterOld= (DAOCluster)query.getSingleResult();
       
       //Obtengo el objeto cluster que reemplazará al anterior
       query.setParameter("clusterid", newClusterId);
       DAOCluster clusterNew= (DAOCluster)query.getSingleResult();
       
       //Creo la lista de entidades raw que me servirá como criterio de selección 
       //para ejecutar el update
       List<DAOEntityRaw> listOfEntities=new ArrayList<DAOEntityRaw>();
        
        query=em.createNamedQuery("DAOEntityRaw.findByEntityid");
        
        for (Integer entity:entitiesToCreateNewCluster)
        {            
            int entityRawId=entity;
                        
            query.setParameter("entityid", entityRawId);
            DAOEntityRaw entityRaw= (DAOEntityRaw)query.getSingleResult();
            
            listOfEntities.add(entityRaw);
            
        } */
       
       String querySelect="select d "
               + "from DAOEntityrawcluster d "
               + "where "
               + "d.dAOEntityrawclusterPK.clusterid= :oldClusterId and "
               + "d.dAOEntityrawclusterPK.entityid in :listOfEntities";
       
       Query testing=em.createQuery(querySelect);      
       testing.setParameter("oldClusterId", oldClusterId);
       testing.setParameter("listOfEntities", entitiesToCreateNewCluster);
       
       List resp=testing.getResultList();
       
       
       String updateText="update DAOEntityrawcluster d  set d.dAOEntityrawclusterPK.clusterid= :newClusterID "
                         + "where d.dAOEntityrawclusterPK.clusterid= :oldClusterId and d.dAOEntityrawclusterPK.entityid in :listOfEntities";
       
       Query query=em.createQuery(updateText);
       query.setParameter("newClusterID", newClusterId);
       query.setParameter("oldClusterId", oldClusterId);
       query.setParameter("listOfEntities", entitiesToCreateNewCluster);
       
       
       em.getTransaction().begin();
       try
       {
           query.executeUpdate();
           em.getTransaction().commit();           
       }
       catch (Exception e)
       {
           em.getTransaction().rollback();
           throw e;
       }
   }
   
    public boolean entityRawHasCluster(int entityId)
    {
        boolean answer=false;
        
        EntityManager em = Persistence.createEntityManagerFactory("SNAFromSpanishTextPU").createEntityManager();        
        
        String queryText="select count(ec.ENTITYID) " +
                        "from " +
                        "snadb.entityrawcluster ec " +
                        "where " +
                        "ec.ENTITYID=?";
        
        Query query = em.createNativeQuery(queryText);
        query.setParameter(1, entityId);
        Object result= query.getSingleResult();
        
        if((Long)result>0)
        {
            answer=true;
        }

        return answer;
    }
       
    
}
