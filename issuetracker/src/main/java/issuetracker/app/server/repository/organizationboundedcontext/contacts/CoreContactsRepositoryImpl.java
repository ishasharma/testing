package issuetracker.app.server.repository.organizationboundedcontext.contacts;
import com.athena.server.repository.SearchInterfaceImpl;
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public class CoreContactsRepositoryImpl extends SearchInterfaceImpl implements CoreContactsRepository<CoreContacts> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<CoreContacts> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts> query = emanager.createQuery("select u from CoreContacts u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public CoreContacts save(CoreContacts entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<issuetracker.app.shared.organizationboundedcontext.location.Address> address = new java.util.ArrayList<issuetracker.app.shared.organizationboundedcontext.location.Address>();
            for (java.util.Iterator iterator = entity.getAddress().iterator(); iterator.hasNext(); ) {
                issuetracker.app.shared.organizationboundedcontext.location.Address childEntity = (issuetracker.app.shared.organizationboundedcontext.location.Address) iterator.next();
                if (childEntity.getPrimaryKey() != null) {
                    issuetracker.app.shared.organizationboundedcontext.location.Address ans = emanager.find(Address.class, childEntity.getPrimaryKey());
                    address.add(ans);
                } else {
                    address.add(childEntity);
                }
            }
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData> communicationdata = new java.util.ArrayList<issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData>();
            for (java.util.Iterator iterator = entity.getCommunicationData().iterator(); iterator.hasNext(); ) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData childEntity = (issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData) iterator.next();
                if (childEntity.getPrimaryKey() != null) {
                    issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData ans = emanager.find(CommunicationData.class, childEntity.getPrimaryKey());
                    communicationdata.add(ans);
                } else {
                    communicationdata.add(childEntity);
                }
            }
            entity.setAddress(address);
            entity.setCommunicationData(communicationdata);
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<CoreContacts> save(List<CoreContacts> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts obj = entity.get(i);
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
            issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts s = emanager.find(issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteAddress(List<Address> address) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (issuetracker.app.shared.organizationboundedcontext.location.Address _address : address) {
                issuetracker.app.shared.organizationboundedcontext.location.Address s = emanager.find(issuetracker.app.shared.organizationboundedcontext.location.Address.class, _address.getAddressId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteCommunicationData(List<CommunicationData> communicationdata) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData _communicationdata : communicationdata) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData s = emanager.find(issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData.class, _communicationdata.getCommDataId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(CoreContacts entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Override
    @Transactional
    public void update(List<CoreContacts> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByTitleId(String titleId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTitleId");
            query.setParameter("titleId", titleId);
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByNativeLanguageCode(String nativeLanguageCode) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByNativeLanguageCode");
            query.setParameter("nativeLanguageCode", nativeLanguageCode);
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByGenderId(String genderId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByGenderId");
            query.setParameter("genderId", genderId);
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<CoreContacts> findByTimeZoneId(String timeZoneId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findByTimeZoneId");
            query.setParameter("timeZoneId", timeZoneId);
            java.util.List<issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts> listOfCoreContacts = query.getResultList();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public CoreContacts findById(String contactId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("CoreContacts.findById");
            query.setParameter("contactId", contactId);
            issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts listOfCoreContacts = (issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts) query.getSingleResult();
            return listOfCoreContacts;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
