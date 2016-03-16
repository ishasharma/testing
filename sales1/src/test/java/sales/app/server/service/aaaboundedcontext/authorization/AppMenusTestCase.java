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
import sales.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import sales.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus() throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("wYKhQX4O0rCe5bL4BkOieUZekcOq5nxzfSAWYBCVy1GxMawdpl");
        appmenus.setUiType("UE5");
        appmenus.setMenuDisplay(true);
        appmenus.setAppType(2);
        appmenus.setMenuIcon("uE6KwgdkMA7Gex8R7Uayl3JcG4PwLLTFKNpCEwRW6FuAz7afCP");
        appmenus.setMenuCommands("jHSwKypWN2PzGqAvMfdTcTr2w8dBaHY50wqHqbVacWyG8p8by1");
        appmenus.setAutoSave(true);
        appmenus.setMenuAction("afx1DGE24fYpTlgCCEwhWVcRJ8veMQzSQQEnsFeoDyHhVGIdit");
        appmenus.setRefObjectId("L8uobVDkxfQQqEUoK9U8NWELgwIPniZYKMi5CURGDd8cQaVTBh");
        appmenus.setMenuHead(true);
        appmenus.setMenuLabel("t3bhMQJGYAXaXLs1CPc7MwVC8rXcQ6PKq2bDt1cn1263For67z");
        appmenus.setMenuAccessRights(10);
        appmenus.setMenuTreeId("KwrRn2uIg6EtjDjo40p96hXxBcn8tTN4axFggSIbjRa1xJBHm7");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus();
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("VsbuqbD2HLP9UJ0Gd1jienwMB7w8ioSLNfiThEwjKfleLz53Hf");
            appmenus.setUiType("U62");
            appmenus.setAppType(1);
            appmenus.setMenuIcon("e9ezazdpRunRP3zndAa3X1Y8RyC6gfTw20uJDARWpgXs1Okmys");
            appmenus.setMenuCommands("2ZMysKP3ri1TZpfNAfGFOCvX6TmQ27Zv9xi5QmYkcAO6uRi7RS");
            appmenus.setMenuAction("GUPsXqjxwiBIXx86yGWylAvO03Qp1jUS3uPuiamTQAPcRrqnmh");
            appmenus.setRefObjectId("CU10gD02TIrK58Lgfon90hmafLrecaGu3SfERJ8L2ikggj1iTs");
            appmenus.setMenuLabel("PFQAszVcnaSxpANCN9pmmvk8ObiMUWpsF2fWElZT5vxXteAyY0");
            appmenus.setMenuAccessRights(7);
            appmenus.setMenuTreeId("G1N3VZwDDZwBq2SWxOqbCqow0KJqJ0LBq1Hdt5Gdt6srqsBXVf");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "pTohLOJvSYOKB02djro8Pce4C6FqaWvLVHCoiRJu3FHAzoD0XwS4VdiWeZNkm3cZ6Om3fq9Or8k1hunXpmABRaz0zFiPcLNNC3kCbmzL2P28YiZTR1ZVyR7oTIScKBydYirBUnUK12kBprUEGskQwGeVoc5fb5rk4zds1XVwiJHj7GheTMr5kzEGiWW71q0JRhoH1XsidRjGFJ1OcNWHlyVQxSOymAhnQgObSWikYxYsdASgRzRiKsFLh9WAgnWB0"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "InA1GOYIHIYIsW7ynRBOlKWcsnhPpPMk6mZbfS2hBMGLoIplWJCqCUDF0Hg4Ekh01MixUvIyGzD1kZbpVsyaaL32eaNFsZNbdSo04Yt0GgTLTSPkDURLlEUbjOp3eulPAmXDujgOTTMCt8u6LBgmS3lp7ZojrtkAN2zxOtCDAMGFpJTNNRXmMkBC0zEQ3arCGkoc47mFsZVw2QzDnhU8vOllcQhD6CYWfBLn9opVh69U2wD1pPnoXY0NutmcOtCuh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "4ZHkhHvZuKES78txpuHr7BgnoFITJJytACA2yvFReDSczPpxK32IhlUSDH05RKebruZNb0AdeYzCjNdLUCCWJRagFGt5UjUbXDiJ1huy048rVtpgjDWNo42gvm88lnFAsnPbrmcvO5GkNU2KhCHiMMAHKJtGiVec7L5qwGPgAFuRflqz9DXWiRcgmqR31Gru2svORLVTTTXVlwpOdCbHtAQEWLkviZhpBgvxOsUQ3peL1UBCb2SC6N6sZ98YehQSN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "e08Bk1kYgbtHDU3Y9dyLoc6pHf2bHvqw2XuPIWfR1ziRGyNI03NSxRvVPFssquK0t"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "Z1zrVXEqNWZV2iQ92JOdTFq5bShFC1J5DMGRYiUVwRFrMloRrjMUAOxP5tp7GMYLguZ89e5a9j9J01QEnuvCTl8zAwL9jomRSDkHKZHTckNSIoAS5w0YlyFTpLHT4rhPG36goYwOy8OmiAsBU05Lkoh3mPQoNKhX0hQ75LiLUo9pPCX4OPr8du61QzPi9P2ZeUIb7EMKPvimpxWmw7beo6wpUVZecCgt6iVw0ijXW5ww4EzXH4fEwanSlT84YkBdo"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "GkLw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "XNvTc1f6MgN87WvpgVLKKFLbKQlUDbzQ5TVjaORrORzQZbUIPxIuDNnh08PdJPjqUULn1MzN6AW9Uw62umOcYYYVcZl2Ivpy694ENYkHHy6SZw9h3cUuRlLx7lZHJRr4Byw5Z3Xtv3uhl8MRkP03dVGzDwz23mS0adt0afETkOLyQeN3jB7YfOZJNgwEq7PcTGkkWgqoanbXIvTgJwFKNf5LJ4ETuAbRgsRQNpdV4yHi2Igcp1AZS79EVXi4wODZV"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 17));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "oZ14dWyNkXYNMLCdF6mhkp2QtWyJidkz3skK7hgnSA51Xeex4hz8rWxmyDvc7zonv2uqoFtxhCWGTzlYMpUfnMhSYvMRpEBHJTy40FLTUgk1KxntpGj3Eg0Qbk3wCVmGIDmcWm1HocnrLU7ATKTrFz8Kyc4IEf7Ga8n3mHViuCoPqU67VPW4VaiEZpOACia1D26IpDOqtSlTfSoGP5DgdXaouzUxOF1klA5fQVHkeuq1JxhMRc0xfjShqSq94KWbM"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus();
                java.lang.reflect.Field field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
