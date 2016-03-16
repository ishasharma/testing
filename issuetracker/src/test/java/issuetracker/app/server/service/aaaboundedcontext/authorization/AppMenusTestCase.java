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
import issuetracker.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import issuetracker.app.shared.aaaboundedcontext.authorization.AppMenus;
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
        appmenus.setRefObjectId("tfv3ckMoeHuhcq3cwbzA4SC1AKltqlhLp6bXGJA0ACFN6IQgof");
        appmenus.setAppId("qBUeynIRZsHCEktUPEYn2V8Wi1i4oxuscSX9SEhNjYhd0MJJX3");
        appmenus.setMenuTreeId("JdQfdUNO87kKlGDW5zVYj3Rk9HaVU1plZs3YkqqfVbTdpUjhCW");
        appmenus.setAppType(1);
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("CVkajlsiE9ErJuTBiEkZquUG4KqUGVba7Kgaho01xWLwdh249C");
        appmenus.setMenuLabel("yD0GtJej0iewFPe9MCkY5XwaF5Pry6z60gwIBL0NOz8F4rypRz");
        appmenus.setAutoSave(true);
        appmenus.setUiType("SEO");
        appmenus.setMenuHead(true);
        appmenus.setMenuIcon("IUtVcbRHagiHXzXtx3tLx9Qv8uSGbqq0m98A40GoCh2Pmny9Pq");
        appmenus.setMenuAccessRights(4);
        appmenus.setMenuCommands("FBUtWbsfAECopiQpZqectm5dokNFPRpX9aCVOCzFKFc5gcuXUq");
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
            appmenus.setRefObjectId("i6i1sH8RuBL2PfBd8sPEbjkBFdUeXWuu9AuNE8LBAkIjWY1Smo");
            appmenus.setAppId("RcaXdxqE4pfvV2YzItPVJAvIgWQ3uHo07rcAbd2ay9QfDxWf3u");
            appmenus.setMenuTreeId("v5SaX3XJ06wPTg1Rg6wdRpTXB6YaNjg1cMqmh5JhOwLPjS9SsI");
            appmenus.setAppType(1);
            appmenus.setVersionId(1);
            appmenus.setMenuAction("WSqJuIXiSFPQJ016bY1UXn3E5Pk2v5yXoKwkScoonoXIhnY6KG");
            appmenus.setMenuLabel("4U1yCV6HTlZfvkzFqw0eFlRa1YN7Fe9BmpUiferAK1aZc0vDYd");
            appmenus.setUiType("WQl");
            appmenus.setMenuIcon("wzB3XK5ZUcMYJphjky531cV864kstbjIl77OD5uTTB7r8sYvyX");
            appmenus.setMenuAccessRights(6);
            appmenus.setMenuCommands("Orh4bPfeOUqINXDTJWcNEcRQm41ooOncdMCZIQCPkToQrdDFOD");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "HwfqDI0Rg18GOFN4GgZoaqYlcs03iJ0Vh50mejfq2R0myd2j2q6z9r2IkYES44hswDMrT7veFoATiqyy6XvaT0M3HNua3mrDqSR7jiDj2wTheocyoMyYJ7dani4PwXVbpxRpjUEDtyCXbhcOogtT1Sep50KGa1kAAE3cWwkdlw5CjfEOo6yctWP1jmF2IYKkNUKX1ShhV7cMpwgobJI8OxByqykWt5rP5jKabcqPpWKG9FkOVzw5ENii5T4jJcqt6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "xwAR6ttzW0n8kCJj7bSyQWGG2lPaCovFBH96Ird1K0Hf5jqQ0vCtMWeHSDaVc1VcRPU5qYKboj554ZwU7S0EA3OC4I9Hv9zFSWybeW5d3q8zVUF9TUUc8d4BZCe7xqCUqLBEtcMNApJQVj9HcCj2waDFyx5tFxEhYLTjdz7D8QQ78GkSfhIpEDUtDicQpxOcduao8Hy5W8KHQdYoPmxCgq2hfjo6FmetpFyIvwLSaairfgahlzJ2UVTeFTOApqii9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "ZfvrBV95Qk0LbArGob2KNUZfxZ8YoxDGcHSOEpOMfVfwcggoJLt3vM80LBnm4E6rm4uDAw2MKNBfRTyaAmRdnH4eGvkUI29vYUY2L6rmJ1f64hZ9tbBWJLxPWmGsjciADdRax7q4schVPviaHM9lzQ8CBWY4I3OrD5Q5Vr3zYP6DO130lu8UMeLc14dtVQN9qwuULRzRoTCnfxlCFy8hxoLBoLSoSNGzB5yQuaeCsEl1rCoHpNAwWREgalctO6K4h"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "QBHRjKsjZqoikjpuPM1XhysY5QzIsNZ7ly92aphmAvuMhKlDEact5NahMUyEh0BbN"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "QdJPXitMGdWhtwFur1hmRnPmZ5ceWWhH1NUGoPOyKCHieKasndZr0WiaBODH55CPKzodSFwueDNpF2qykupKuRMZJS9mnRxuxRobPPafZl0Lok4UdaBfPNbkluaCi0P7RFaNBDyWMVRgxy3LtZOa6Xz2uORN0PU7KJsn768scc40EC9CuRT45UbTuMlv3eo31jUhtAxzUfBDnIqEW7oZVFQZEB62NWIFB0BV8B6me8B1MpvKIHdfmfGvwNe72lVrh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "S6VG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "LLgoyRB93LoO7fpe2VoriFQO9jK5hbo0Ihp77zfediQWjFZENlpuiAbUdKdlhbKwtpU5XLXvmRxfn5lmN8k850zw3b1UgOv1W94CWSCrNdMXy1MeKQ8uNzyDJvhhbqSSwSDPToQ2dY6ncH6isygtcd8h2a1CgGrPUyU60MGRKkEHzSxxGTksFhLlLZSbFcMDJ30uO40vxuiv9VOwmLn10aetY9RBi3QLUPt8EscGLHBQww7tn8QGx2EvjiYJsJBnJ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "iWntXqLzpW2zH62WPgan14386pcdCRRp6ecqgybE3JbmunTnrJL1Nk2uENSOjtYrkOOdzNcmOPAFejEXZEBDJoG6B0CUnJTkJ0K9EEIMKFcCOBqwp7VweG2KhWs48zMdhOlIqhlVDLoruIGa3pBwAxXiDXbpqiBAgaws7mDYkd5ytWCJsBu8Lo79y1NXWIiqg5C8ofEqmelaRydttdjMcqNJw2RDcdgwDvyErA44X0O7Gd4VIDNRlLRtrIU5QI3v3"));
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
