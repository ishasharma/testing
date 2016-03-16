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
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class ProjectAccessRightsTestCase extends EntityTestCriteria {

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

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

    private ProjectAccessRights createProjectAccessRights() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("T9FjLJRnavbLJsqk7qTAMrjymrDNS8hMyNpyZPY8YzCT9YdHms");
        projectaccessrights.setProjectAccessDesc("PoVb55EhkL1rNmtKKVAjyaGfRJidZswy5S5IVpaZMa26yXv48y");
        projectaccessrights.setEntityValidator(entityValidator);
        return projectaccessrights;
    }

    @Test
    public void test1Save() {
        try {
            ProjectAccessRights projectaccessrights = createProjectAccessRights();
            projectaccessrights.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            projectaccessrights.isValid();
            projectaccessrightsRepository.save(projectaccessrights);
            map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            ProjectAccessRights projectaccessrights = projectaccessrightsRepository.findById((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrights.setProjectAccessName("ipOknnGWcq46jerHMIu9fUMQBkO6Vcf6bN658jH4HU0CQhOxoQ");
            projectaccessrights.setProjectAccessDesc("LbFRtJaIf6IPGDI0yGQGsnHewGPPMyySi1okrgLjyJqNW51U9F");
            projectaccessrights.setVersionId(1);
            projectaccessrights.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            projectaccessrightsRepository.update(projectaccessrights);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrightsRepository.findById((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ProjectAccessRightsPrimaryKey"));
            projectaccessrightsRepository.delete((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateProjectAccessRights(EntityTestCriteria contraints, ProjectAccessRights projectaccessrights) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            projectaccessrights.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            projectaccessrights.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            projectaccessrightsRepository.save(projectaccessrights);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "projectAccessName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "projectAccessName", "pa5qd95IEKRkKqtjnKetSL0wYdl514Umj7UvKARlQ204bGXjnrHG59XeESRLwS5nVnVoSIWMgLGFmPCz5pLatm2pbmJbjdBvcCF8q5JazWjWfpTzDKQ5gVUEJIRqqQB2F6Whzqz6u7HLNYpf6f6TNJTQFxNi3xBxHb2Fz0OoeOfmtE2liGXAKIBMH30fCrdGk8WPNmnTerTnnp7NlqsUQDrY2Q1ykJO6qlSBpP7JsCWpFiYxiosM73CdAw8Naop48"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "projectAccessDesc", "GmvPjavC1us1hkXrTXd790Y4T7czjcGTuOQ3JeSBUHOX3wKg4rDoqwtb8PbIvNNCcgenaYqTYkEDhmnEbjWR4X8OfgZpgxsfwcrH71HXtAWxMWkAj425aDgKOik43lAdRrr9Vb7Rn7uTjX4DKW7QVgFMbY0LNY3Y5nzNXRceVvFBtWbcw1Y4CJnjVp817E2nf4Hfp2CqVdtoW7QFClsu2hWPYJyb4LusRW93uAjyS7YQLHU88hGzXM6oXcHvoYLYoOIxpH79uqbQXpS21ywHqrT1dJNycQOu9rCvoK2ij0msG39TWaY6odn8b8UiFaQNuzrrz02TN7nV8BxXTjgUyQOzwG4raCviLzAYlBNyXIuRm4qPSwf25SZHoEbG8YAo2nFwMLpR5ggectbVQdSeKIMqGcOX8Fcet5emDVvSIbVePeTKBEO6G9NPIK5Fg7fxlaaqFc3I01PJ4E5BPAfFFBPbokrEVDs6karX2J7EVddpPhc50wN30CB9lROWaCGX0CtD526H8NRm1dUA0U2JE7vhFruVgodbKRQgojBgZ9zQBSHwTQF9Lz4fHKSZKCsuADJabkca0akxecoo3ZCLmrbM4OOwCQczL050kHKrrhczrN31pLjFzDhxs9SDZlWWOgTlJAAmQIZ6rlmOXVHdsx9v5tisIcGuZorwnEv47vYiRUtkxu0FLEpd2A3e0PwRE8OI2f6YU59n94y14C8xCnrdBdjfO6AcCkNrhMBW24iyikLtDpPvg5AbwjUfGalLPyEDxAsTjA1P9e4Ve5aJzwhWbxZxTun1JYTCnrqXBWNR2pqMmBHoE0XBGiKBMyeduye9cNILhDDWuUWVNRo22nJtvRpGKjBoOR1bWXDi2zQ3h3lkGhAQ2KBc2k5tw3vlL1FYY2IXiQ2k5WI8fXJAlYzTmm44HeJ9Z4xDnAZXOTLh7c1kN7GfbOOTjDUOIkCxXDDEiWpYikjuY62TlRnztFkPldOcr5GHZZlPyNb90svbo6V5tCuhCfJXtBYK4ZYzJ"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                ProjectAccessRights projectaccessrights = createProjectAccessRights();
                java.lang.reflect.Field field = projectaccessrights.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(projectaccessrights, null);
                        validateProjectAccessRights(contraints, projectaccessrights);
                        failureCount++;
                        break;
                    case 2:
                        projectaccessrights.setProjectAccessName(contraints.getNegativeValue().toString());
                        validateProjectAccessRights(contraints, projectaccessrights);
                        failureCount++;
                        break;
                    case 3:
                        projectaccessrights.setProjectAccessDesc(contraints.getNegativeValue().toString());
                        validateProjectAccessRights(contraints, projectaccessrights);
                        failureCount++;
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
