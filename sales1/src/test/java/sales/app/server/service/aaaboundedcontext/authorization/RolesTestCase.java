package sales.app.server.service.aaaboundedcontext.authorization;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import sales.app.shared.aaaboundedcontext.authorization.Roles;
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
import sales.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import sales.app.shared.aaaboundedcontext.authorization.AppMenus;
import sales.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles() throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleIcon("DVTzMsSutYIfmByjmDtaOxtcipvkZqCSTVoTtAHkVzeiL9grhy");
        roles.setRoleDescription("FfUaF4IBa2LT47oKUgx8hDoaeDkPrzhqRcoiPmWrYdY1Mjui7U");
        roles.setRoleHelp("OpLIMonEaOzquzpLC28xCPfpwxkaaT46oFLhtEwBjpklpxec9n");
        roles.setRoleName("HeLpe2nf8BBDVVsIE37wdOg0uxVYPah44OaJhY0dW8PkfZUMBn");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("GXycHFBk8S55UoUg98fXYSIFIs07zNQgA6WAMFPJbFV7nuPMuP");
        appmenus.setUiType("V8K");
        appmenus.setMenuDisplay(true);
        appmenus.setAppType(2);
        appmenus.setMenuIcon("eMOvTZXPWUfgvLWguD1Xbw4OheXiFYhJXRRFjRMS1tWsDHqbBY");
        appmenus.setMenuCommands("fwU6AmUzU4qhs4yrtaM56pBludNdWGmoIkKUoZepP4RTOdrFiK");
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("cyY8AfygPZKgZybkisy9m4rhjFFkiJvCn534ybZRoAbthC7LvT");
        appmenus.setRefObjectId("GUBWyGDAZGyGBlOfDMJ0yFrRRDuQytPzcOaRcHRBCIJiAYOoew");
        appmenus.setMenuHead(true);
        appmenus.setMenuLabel("d2CvsZAgGXfq1JEWIpGUdyoJtI5PhPFe3jpHKQeZdVnFfE5HNi");
        appmenus.setMenuAccessRights(1);
        appmenus.setMenuTreeId("VIDkbeGRuMqsOUMjOpq6FvdzKJOr98F4rIPxdkVpjsl8aJ0eMG");
        AppMenus AppMenusTest = appmenusRepository.save(appmenus);
        map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsWrite(true);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles();
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleIcon("hmuIdzvEtxZ5ZzkS6MtDqQwYxcCsDtY9lp1UkvD5Xv0NHNe7TH");
            roles.setRoleDescription("jVlwFxlEjfrSBYdosNCtbtqqvMyo8e4V7vHfhToboiq0Zx4Cd4");
            roles.setVersionId(1);
            roles.setRoleHelp("bFyoHvckYvJ7ikT6i3sut9xNppDludEmlFjlnPgmH8XYV95S3i");
            roles.setRoleName("PtYQFJeBMH8xC94GveWat5fqWA0oyNEh9ZZLMzEdXKT1JPVqeR");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "59oHEnT2Y0qURhdgzhqdrV5SD23rcWRoN4Y23004QgxbCQwAlTVlJWZNHn6EdM5DlcJPl3qLNdPURT84aUF05flMoCKGfCRCdZAIsdEIvgAeH7urfnxhTm8mu4HTEjSkf2Y4IZIv4wdguwrD0dpY3wZTuAcnmLMgETBb3H3WpqyoJb69inZ3ZKFWl5dRObCRYvFJTPSK58c2iiIiUkLPeUbStn80XiBx7iUfX7qq7s8DLNzka9TiaytIJ3nGIMecf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "DIXJTeCqRrxX6qZa5ig7YanE7qbFioOVPuM0TZxUHxK4VWansc4O81OiW00v1vGSDIr27ftkgHfU8mYL399ZLbmyP5cBfcb3YMSVQNgvddjz7TDEgb92WtifXN3jgCwUNwjmz00BUyKS4DOaScgnpnky1GxyAOVaRpAYuNrbQjCJlJIBpZ1xDg8RfCij95girvu6A9JwEQCEyMdJUEY7xlYh815LoKZqazFd2gKgf6zqFxVSkT9ltFBBgc7keTg5a"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "uX6UHyu28vDg7VeoQFlAvKBgD2qHTDkqbEONX1fKyQHhxSjTfNveHkWpYGt2Rh1Kx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "SQJ9mtu8QDtpAreqHLzEH9woaAMFkbdm5pqwtxRDaZky7KyO31ORHQToMWzT1ZRr4j891oQ4XXXL4XWfWUt5CWrMqOcKDmlqp4eGHayzXm4JO6f1D9JD6ERRZunyWeHB0YwmH0IHUMaFgJsTd4mcb809urwknZ52UrfUF9VYQnJxsbaGFNwO2zFYj2xvDRUAOzR9cxaR4JjOUVHukAxwhcdRwpZD4FcxayhEhDVK9rujrRMSmojR70CwWeSvaDv7C"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles();
                java.lang.reflect.Field field = roles.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
