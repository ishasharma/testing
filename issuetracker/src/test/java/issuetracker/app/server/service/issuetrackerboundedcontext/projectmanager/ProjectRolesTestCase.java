package issuetracker.app.server.service.issuetrackerboundedcontext.projectmanager;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectRolesRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectRoles;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectRolesTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectRolesRepository<ProjectRoles> projectrolesRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private ProjectRoles createProjectRoles() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("5hUcIYvXbqrDKskdo6SiyUjLsD58Qxh0ZaoGrD3QYuWeyd8x7x");
        issuevisibility.setIssueVisibilityDesc("OHUKr6Itgl4trQGAqBfZfYAa91PljWZrvKIOFG3k37dlLPwLcb");
        IssueVisibility IssueVisibilityTest = issuevisibilityRepository.save(issuevisibility);
        map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        ProjectRoles projectroles = new ProjectRoles();
        projectroles.setIssueVisibilityCode((java.lang.String) IssueVisibilityTest._getPrimarykey());
        projectroles.setCanAssignRole(true);
        projectroles.setRoleName("KDskQ1Og1Baj6T11aXBXCPJPv9UkTcEsFVz8u28w8w0PS6GW95");
        projectroles.setEntityValidator(entityValidator);
        return projectroles;
    }

    @Test
    public void test1Save() {
        try {
            ProjectRoles projectroles = createProjectRoles();
            projectroles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectroles.isValid();
            projectrolesRepository.save(projectroles);
            map.put("ProjectRolesPrimaryKey", projectroles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectRolesPrimaryKey"));
            ProjectRoles projectroles = projectrolesRepository.findById((java.lang.String) map.get("ProjectRolesPrimaryKey"));
            projectroles.setRoleName("0rm3f6EzDgVcYzg8iKhVqBA4qghoQrErHNFj5rqbxzq4do2ECL");
            projectroles.setVersionId(1);
            projectroles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectrolesRepository.update(projectroles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueVisibilityCode() {
        try {
            java.util.List<ProjectRoles> listofissueVisibilityCode = projectrolesRepository.findByIssueVisibilityCode((java.lang.String) map.get("IssueVisibilityPrimaryKey"));
            if (listofissueVisibilityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectRolesPrimaryKey"));
            projectrolesRepository.findById((java.lang.String) map.get("ProjectRolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectRolesPrimaryKey"));
            projectrolesRepository.delete((java.lang.String) map.get("ProjectRolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectRoles(EntityTestCriteria contraints, ProjectRoles projectroles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectroles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectroles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectrolesRepository.save(projectroles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "roleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "8DjGoohmU44FhJnPeyhSGSmkYHvbhP1wFeicL2X8LWABYODGMxuPfEzvy42Cbxdb9PPxADFX0LcPhQZfVt0fgmH54oSG14M598pZT9TXSVsRqtg8eALpvvApmDvi5VsIoK8C1Pb1QrMmwnD3aWPiQTlHtPSmpvQrootZ1h2r2y9BXKfT5E0vjBPPuFILTnELXpiRDlPjPrPEn81tk1fVTi5ID7Lzh6xeeyGKFFGFEXznPVJZCEA2FUs7DTeGyQIKP"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "canAssignRole", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectRoles projectroles = createProjectRoles();
                java.lang.reflect.Field field = projectroles.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectroles, null);
                        validateProjectRoles(contraints, projectroles);
                        failureCount++;
                        break;
                    case 2:
                        projectroles.setRoleName(contraints.getNegativeValue().toString());
                        validateProjectRoles(contraints, projectroles);
                        failureCount++;
                        break;
                    case 3:
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
