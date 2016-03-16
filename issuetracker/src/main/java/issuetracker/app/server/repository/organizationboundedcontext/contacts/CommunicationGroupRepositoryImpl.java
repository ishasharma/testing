package issuetracker.app.server.repository.organizationboundedcontext.contacts;
import com.athena.server.repository.SearchInterfaceImpl;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import java.util.Map;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for CommunicationGroup Master table Entity", complexity = Complexity.LOW)
public class CommunicationGroupRepositoryImpl extends SearchInterfaceImpl implements CommunicationGroupRepository<CommunicationGroup> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<CommunicationGroup> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup> query = emanager.createQuery("select u from CommunicationGroup u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public CommunicationGroup save(CommunicationGroup entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<CommunicationGroup> save(List<CommunicationGroup> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup obj = entity.get(i);
                emanager.persist(obj);
            }
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity Saving", e);
        }
    }

    @Transactional
    @Override
    public void delete(String id) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup s = emanager.find(issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(CommunicationGroup entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public void update(List<CommunicationGroup> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        }
    }

    @Transactional
    public List<Object> search(String finderName, Map<String, Object> fields, Map<String, String> fieldMetaData) throws Exception {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery(finderName);
            java.util.Map<String, Object> map = new java.util.HashMap<String, Object>();
            Map<String, String> metaData = new java.util.HashMap<String, String>();
            metaData = fieldMetaData;
            String inputStr = "01-01-1850 00:00:00 UTC";
            java.util.Date date = setFormattedDate(inputStr);
            java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
            for (Map.Entry<String, String> entry : metaData.entrySet()) {
                boolean matched = false;
                for (Map.Entry<String, Object> entry1 : fields.entrySet()) {
                    if (entry.getKey() == entry1.getKey()) {
                        if (entry.getValue().equalsIgnoreCase("integer") || entry.getValue().equalsIgnoreCase("double") || entry.getValue().equalsIgnoreCase("float") || entry.getValue().equalsIgnoreCase("long")) {
                            map.put("min" + entry1.getKey(), entry1.getValue());
                            map.put("max" + entry1.getKey(), entry1.getValue());
                        } else if (entry.getValue().equalsIgnoreCase("String")) {
                            map.put(entry1.getKey(), "%" + entry1.getValue() + "%");
                        } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DateTime")) {
                            java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                            map.put(entry1.getKey(), dateValue);
                        } else if (entry.getValue().equalsIgnoreCase("TimeStamp")) {
                            java.util.Date dateValue = setFormattedDate(entry1.getValue().toString());
                            map.put(entry1.getKey(), new java.sql.Timestamp(dateValue.getTime()));
                        } else {
                            map.put(entry1.getKey(), entry1.getValue());
                        }
                        matched = true;
                        break;
                    }
                }
                if (!matched) {
                    if (entry.getValue().equalsIgnoreCase("String")) {
                        map.put(entry.getKey(), "%");
                    } else if (entry.getValue().equalsIgnoreCase("integer")) {
                        map.put("min" + entry.getKey(), Integer.MIN_VALUE);
                        map.put("max" + entry.getKey(), Integer.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("double")) {
                        map.put("min" + entry.getKey(), java.lang.Double.MIN_VALUE);
                        map.put("max" + entry.getKey(), java.lang.Double.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("long")) {
                        map.put("min" + entry.getKey(), java.lang.Long.MIN_VALUE);
                        map.put("max" + entry.getKey(), java.lang.Long.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("float")) {
                        map.put("min" + entry.getKey(), java.lang.Float.MIN_VALUE);
                        map.put("max" + entry.getKey(), java.lang.Float.MAX_VALUE);
                    } else if (entry.getValue().equalsIgnoreCase("Date") || entry.getValue().equalsIgnoreCase("DATETIME")) {
                        map.put(entry.getKey(), date);
                    } else if (entry.getValue().equalsIgnoreCase("TINYINT")) {
                        map.put(entry.getKey(), 1);
                    } else if (entry.getValue().equalsIgnoreCase("timestamp")) {
                        map.put(entry.getKey(), timestamp);
                    } else if (entry.getValue().equalsIgnoreCase("integer_userAccesCode")) {
                        map.put(entry.getKey(), runtimeLogInfoHelper.getUserAccessCode());
                    }
                }
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
            java.util.List<Object> list = query.getResultList();
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public CommunicationGroup findById(String commGroupId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CommunicationGroup.findById");
            query.setParameter("commGroupId", commGroupId);
            issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup listOfCommunicationGroup = (issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup) query.getSingleResult();
            return listOfCommunicationGroup;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
