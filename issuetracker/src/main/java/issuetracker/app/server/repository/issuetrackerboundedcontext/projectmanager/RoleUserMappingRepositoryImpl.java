package issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager;
import com.athena.server.repository.SearchInterfaceImpl;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping;
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

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for RoleUserMapping Master table Entity", complexity = Complexity.LOW)
public class RoleUserMappingRepositoryImpl extends SearchInterfaceImpl implements RoleUserMappingRepository<RoleUserMapping> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<RoleUserMapping> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping> query = emanager.createQuery("select u from RoleUserMapping u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public RoleUserMapping save(RoleUserMapping entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
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
    public List<RoleUserMapping> save(List<RoleUserMapping> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping obj = entity.get(i);
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
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping s = emanager.find(issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(RoleUserMapping entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public void update(List<RoleUserMapping> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        }
    }

    @Transactional
    public List<RoleUserMapping> findByPrjRoleId(String prjRoleId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("RoleUserMapping.findByPrjRoleId");
            query.setParameter("prjRoleId", prjRoleId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping> listOfRoleUserMapping = query.getResultList();
            return listOfRoleUserMapping;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<RoleUserMapping> findByContactId(String contactId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("RoleUserMapping.findByContactId");
            query.setParameter("contactId", contactId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping> listOfRoleUserMapping = query.getResultList();
            return listOfRoleUserMapping;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public RoleUserMapping findById(String roleUserId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("RoleUserMapping.findById");
            query.setParameter("roleUserId", roleUserId);
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping listOfRoleUserMapping = (issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping) query.getSingleResult();
            return listOfRoleUserMapping;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
