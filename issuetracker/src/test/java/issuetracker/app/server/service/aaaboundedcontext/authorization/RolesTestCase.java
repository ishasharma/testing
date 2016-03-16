package issuetracker.app.server.service.aaaboundedcontext.authorization;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import issuetracker.app.shared.aaaboundedcontext.authorization.Roles;
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
import issuetracker.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import issuetracker.app.shared.aaaboundedcontext.authorization.AppMenus;
import issuetracker.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
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
        roles.setRoleHelp("2ijwZZQCcoZaHJyUTvuSzAUJxiK9KgWNvybH6jIcSaFZT748lR");
        roles.setRoleDescription("2l20jgh4UGh048L1FPP26u8jKkvkvTL1ktj720O1Pw2eqxD2TE");
        roles.setRoleName("xxSBhF8TOjBtr2PE4jZ8rREW0zR5Yj7gv8SIhGSmujf2fBzbeW");
        roles.setRoleIcon("2DsdvbOrCa4g4wgAohsxEb4acHt9jazmxQCkcpCQfH5LKA3ISz");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsWrite(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setRefObjectId("4BmhVv3iV52AV5zaN1CHdV8jMz5j2KGupgj8kf0HFXYeYD2kuZ");
        appmenus.setAppId("FToJWxt0mSMLSTjuPzAgpWoSc6qBzhdffOscKk2WD50buExFLG");
        appmenus.setMenuTreeId("toJCkg3CCt0SlCKoS9xWhjfaxcEmFCh4GunlR7mAUiAebLLCZn");
        appmenus.setAppType(1);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("8dyh6zssiSDk73CzWZ8sNQ3dEuu1h4tgVUxAE6xvCFzrZBmfL1");
        appmenus.setMenuLabel("uxOSASEAhGEqlATzddhLjPVtJpFU3h4IZVAA9STj070G7sPcQ8");
        appmenus.setAutoSave(true);
        appmenus.setUiType("Pqp");
        appmenus.setMenuHead(true);
        appmenus.setMenuIcon("160w1yT5e8JoJjINGMlewFMBTlIM5dXAm9jKeHT3kstnPJqxyO");
        appmenus.setMenuAccessRights(11);
        appmenus.setMenuCommands("3XvFcfRaP31GYbupBtRsKW36XRpg1QmPPP3KC3hHebW2UED4WP");
        AppMenus AppMenusTest = appmenusRepository.save(appmenus);
        map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
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
            roles.setVersionId(1);
            roles.setRoleHelp("dNSxMBA6p8M3RQISPRwXCOanoy2K9Ris1wuTqgNb4Ut1WG8Khp");
            roles.setRoleDescription("iSUkIbfViY0j2o193cHJ3tHZRLXZtuJaStzkArtqV3MRFio95P");
            roles.setRoleName("0N6OsjnhiU8gewIuMwmFGNvq8uO8sY9WOjlIzqvyksZSknsFid");
            roles.setRoleIcon("fJps0tDYPw37ShBHqscOej2ByGEfL9hwMBs7XbRfHzPsuEJWw5");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "A7mDyocCqxdwdpKkL3KBQI66VzgnZF7RuUNQz86T2sd1JNI8KLk2fqZZMHOJetct2ontC5cb3MLp0Z0Hig3DBIOr6J5u86TZWToG1EfWHh8w5oofoSXBxlCmqO9Nx4iadZAdWeFA9Tmzm4piS0o1bPMumbZVk1ayOURkW5Rl5wnOnrCntDIRhJ9WCFLaWQL6HAdwWySZ3XbBlhcAxzpIiPCkhTVPANLrCIe7Ns7TFAifZnrNSuNJLso9NUn2oo97r"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "2WujWszRfu1sfAkdarwUnqmNjH1UeQYtonXSYurAdXr4H1HcT5Ah2XIHaXhl6mNlVXfTaKcroZih6rVO62SBnasbPlhgf18XpLXgA7Drg6JIdc2U9odN8UubiVZpCuBv49hkBvi1a83QxllzfLsyvylxjDee5ngcv4aAdGMZGL1Vf3pm0WuYHiLmWUzf2CvwuutkSxNLYmQhlbTwG7mjB5GFxGh6C2QJZovTPKLOtSQRtkQjCLQsUNC9HO9bul5df"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "QDE3V7qhVM8wH6nktVGBt2c4OgBjIL6gMjPnMV9eKTcWXeKsfwmEVmdMd6zAhQueA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "EE0tOw1v4i1XW4ELyOD6NHmPooLw4kETdsIzbbY6yJLSxf67em0dMHqnhAzyIkykLMgeI0hjXnbqFFtfEoJtWOiIUzpFnSAG76CeBpB306EyPrC7bNWwEHTq65ZVZKGWwl1erq8uQxvW0FTDiq7Km5BLDJ4fb7fuXzSmSxQxmTMxWt4ZMyTgPJg3A6NWJkO8qu9ZEMVyhQQHPmn7UUabVsjUp3s769WSCi0JD4eBdrQXzg8g62WXKw6Yasw90dTlE"));
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
