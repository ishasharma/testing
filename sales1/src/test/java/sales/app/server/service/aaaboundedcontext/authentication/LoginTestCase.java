package sales.app.server.service.aaaboundedcontext.authentication;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import sales.app.shared.aaaboundedcontext.authentication.Login;
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
import sales.app.shared.organizationboundedcontext.contacts.CoreContacts;
import sales.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import sales.app.shared.organizationboundedcontext.contacts.Title;
import sales.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import sales.app.shared.organizationboundedcontext.location.Timezone;
import sales.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import sales.app.shared.organizationboundedcontext.location.Language;
import sales.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import sales.app.shared.organizationboundedcontext.contacts.Gender;
import sales.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationData;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationType;
import sales.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import sales.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import sales.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import sales.app.shared.organizationboundedcontext.location.Address;
import sales.app.server.repository.organizationboundedcontext.location.AddressRepository;
import sales.app.shared.organizationboundedcontext.location.City;
import sales.app.server.repository.organizationboundedcontext.location.CityRepository;
import sales.app.shared.organizationboundedcontext.location.Country;
import sales.app.server.repository.organizationboundedcontext.location.CountryRepository;
import sales.app.shared.organizationboundedcontext.location.State;
import sales.app.server.repository.organizationboundedcontext.location.StateRepository;
import sales.app.shared.organizationboundedcontext.location.AddressType;
import sales.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import sales.app.shared.aaaboundedcontext.authentication.User;
import sales.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import sales.app.shared.aaaboundedcontext.authentication.PassRecovery;
import sales.app.shared.aaaboundedcontext.authentication.Question;
import sales.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserData;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458129749668l));
        corecontacts.setAge(46);
        Title title = new Title();
        title.setTitles("JvDOgzPgIQEq0NFiK46nuh07vGTgBNYYlQ2KVTLXZeAa8mbvup");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("CKrz339H7GWTwsLbxFcJmKkOXi7LWZO0orID912BpKV7YYwsBk");
        timezone.setGmtLabel("e5ZELvSKrko4Ii3E80gWQ3RLEEkO94YTLAvNjdUZVwTkNxkmIk");
        timezone.setCountry("sOFVjnoYYCSdCs6ZuZsfjUTeYIppB6XIjeLnjmmuA5CDGzSvUP");
        timezone.setCities("qcmX07qcOgVkrgXe0HW1Frqs7S7P7vzEFiEI7ZdJ48SkCXi60p");
        timezone.setUtcdifference(10);
        Language language = new Language();
        language.setLanguageIcon("RpfATrlcLNyVehs0kuHRu9Y1yHLK2DKa6YXydoV1aBYENJrZZK");
        language.setAlpha3("d9f");
        language.setLanguageType("Qpt38Nk83X2KvG247PKy29IUz6fAxDMO");
        language.setAlpha4("HX4T");
        language.setAlpha2("fB");
        language.setLanguage("eYnhKGXsReHopevOqnDE6gXTosCmIdIgj0SEVZkUWtXoZr2WqY");
        language.setLanguageDescription("1pDdYuqH6VHPQyo1D0j8VDCohLGzF6FY3GFy59JQwLSG22145T");
        language.setAlpha4parentid(5);
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("5b5W4FySejBloHKP4ySlI8h34zLJIgahPaRGjlb3Jh2Dr9XIjY");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458129749689l));
        corecontacts.setAge(39);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeMiddleName("jnS1GgKyyCSPrAL1Fb0DodmB4ikY7lOM2QUZtBngH8yUeGkQlH");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458129749741l));
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("vYQTUdHBEK3hodLXciunICa0nzpnBnv2J11jVMec4flN0ox0yw");
        corecontacts.setNativeFirstName("K51TS7t3bPmv7VnQ6ohZvtEYnmuzJxV3o3mtOjyNirRQZmtMDY");
        corecontacts.setEmailId("H4KTlnYrvMkEIrsh2D1BHnX4KhjaagYuBSP4M5LpURUaJfdOOn");
        corecontacts.setLastName("pfEyjA8utNurcfIt8Un2kLibrup0BboFOzFt28diLSArMSsbOx");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeTitle("J95QTqVs3XPQYt1mfNGjYyKUKhUjzwIDFzRMUN9nSKgIWX72vC");
        corecontacts.setNativeLastName("tFLmZ5jYyT5PBGQ2Ztjai7aRI6gAIoMntNIFINGhZ4JKoBnzkF");
        corecontacts.setMiddleName("ls6oYtqwN2J92oyWZrdh4GIiVjTMBStDxe9HDIBQGbIhPjLGLW");
        corecontacts.setPhoneNumber("mKXqLRSuAQXeRxAkJHia");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("eaxA98nz8tQvDgqqzi8QhBJ2DBqUw1PRY4Lli28NGZ0u2iro4J");
        CommunicationType communicationtype = new CommunicationType();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("h8cALPyJwutsddS19bAf4dGRd6m2SCGc6RBG5WCwnmbx9I6rs1");
        communicationgroup.setCommGroupName("lJsyfLUA3zsoW2T7E7bztc9j8V0PTDQx5CXFIfb2P1HtLQVVL1");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeDescription("DBOcMaiLDGCHB20HMufHyG0hgUHm2ayFfpDGBnPzNJY2Lt63B1");
        communicationtype.setCommTypeName("kJ4i5JzrkKinKapVQc2yGcp7AWeNfcx36FxvLDWm9G1ESSOSCv");
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("Ljn4jcaXEyMacZ6t8agpMEht7lFxdJ1KjRM73HxWWmhC3MVtMD");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        City city = new City();
        city.setCityFlag("EvMF2jTl0ThlEYdZk1ygiJ5aNwomOW7vPwW5tsmqNfMuIaZK5V");
        city.setCityLatitude(9);
        city.setCityDescription("NHZuiD8smNl7CMgUGA94L1Xyjiu7j9AEFU1zQNKptkyHyzCZW0");
        Country country = new Country();
        country.setCountryCode1("xCy");
        country.setCountryName("sqxvTko2WVXnmaB7L33XzmrJCvOU3AlHmJBVDfVpFXhwV30xmy");
        country.setCurrencyName("T0QvHZiUkXdM4ljmD8loASe4lfrObNumLXx3vjG5vRzskIOsGW");
        country.setCurrencyCode("Pn1");
        country.setCapitalLatitude(2);
        country.setCapitalLongitude(1);
        country.setIsoNumeric(2);
        country.setCurrencySymbol("LOYzB8tcwA71SRnUd145il2aCULKEemX");
        country.setCountryFlag("XemdE63ib7nSxdOCucMwKcjDDrpbs3r1CtQrgo8WAsdSSIygpl");
        country.setCapital("XV7TRolctBypIMTGXNQjnZ6pYhOK6YGu");
        country.setCountryCode2("xtq");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        State state = new State();
        state.setStateName("pdtcsDCLqO9vBfMY5Wehp1ID1rBIawEg099IfmIDY5p0qzAccI");
        state.setStateCodeChar3("XeLP9rjVDxV4NShBF5AkUlJcuie73BQW");
        state.setStateName("1Ol3fJmZ2iDY2gBbpAOuOTaSbQZ2va9GybeU9uHRDkWcx1iCYp");
        state.setStateCodeChar3("5sclbNVpfCG3UQyuNg2gYdsjdwdC2Xwp");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateFlag("0twkcAPz4ATixONxFlX9pDsd9JqSj5YPccQpCyOvfdyCn2BuYK");
        state.setStateCapital("cRT97JR62CjX8po69mbZ0avOdDIFjon5QlMlXI329djJqZa0BX");
        state.setStateCapitalLatitude(3);
        state.setStateCode(1);
        state.setStateCapitalLongitude(5);
        state.setStateDescription("JNkwT4eVMMLms1JOB1LyYtTMitJm452JjwXRto1uGtOxSqHaC3");
        state.setStateCodeChar2("jQPI4gQd7d4eIw3gS80XQgqTpFQDWNfP");
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("uCLuSMOi2HaolmswlDmUXqun8xFmDCBn28IUItKgkRareqWAOA");
        city.setCityLatitude(5);
        city.setCityDescription("YtHhXkgNnpdeYW4kWRrHYrL9lIJcwfvG5CeF9zSOqHAk4LUwiB");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("0IAa8WvUxmtSpkHvoUtMc3gFXqEowCGdIReuiMDz9qDWDOGv25");
        city.setCityCode(3);
        city.setCityCodeChar2("wOR7srgTecwLDXKioueFcG0vmcdt4ZBa");
        city.setCityLongitude(10);
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("gp1YsOjfQwCKhf3N8EmnZELAx5xXLs9XyMkEd24OqLeyZlNhtB");
        addresstype.setAddressTypeIcon("Ok6nyE53NErIS7avaF02ttomUYh5VACOpNUVO7TVITJS4tBr0z");
        addresstype.setAddressTypeDesc("Z0S5WEOYPsawLgNlvuGeopn87EAzE28dOZMlcslKbqxyTmU49O");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("FBUOuNPxaIYlmdXXdiAXBp3UR7PM82CscUnE2cCrvi9cYjE8LL");
        address.setAddress2("ugouGfh2UsFq00DCyP3xcxAvszsk4AXVLpAXWvEN2juqGp5yvi");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("B6RrKk");
        address.setAddressLabel("yP4EXtSdGMh");
        address.setLongitude("2cxaMOEAI3QYzAW1raDEOnrBVvri3r0locAKi32Prbz05r27Wr");
        address.setAddress1("5h5EcNpLidrbHPRSyt8zx0aAP1QhHeTmpfcJJQ4zidkOtlzTHb");
        address.setAddress3("73g9BkoLfbqlii1ZITLF04CLKRIpph3H73tjq3Ixh8I1jvlulD");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("XRaEuWi3hAgGi3CCumg0nFpsGR7pHySEJSmFPoFBe14WZzDrqx");
        useraccessdomain.setDomainHelp("R59GdYDZgZZoT1nV4zzLjdvy5AFizNdDfl3tL9tSOZXGaoqYtY");
        useraccessdomain.setDomainName("gonmvYZ6SfW5DvfiL9YdcIW9F8P9dBbjJ3ZlZ5XUzowhh0WUUX");
        useraccessdomain.setDomainDescription("lXx5naWvSnFTEnyQfaON0LflWgeYskzTAgUFpwe4x844xYtBSM");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("4bgAHLN5QXESzUpaM0i2vDYaLCGIDFbAgoThMCl0obElWfytAK");
        useraccesslevel.setLevelIcon("900daQXhgWr1vfHpFHWkhqctmxyOPINP3cMiSA6r8Rah9LXdgR");
        useraccesslevel.setLevelHelp("re6mPBYpLPShzuamPciZSi62hwVz4A67J8SQvWCBtZKvar9bkb");
        useraccesslevel.setLevelDescription("6RiNGRsKKF9a0ftlw2cwcmcl1EtOykM2L6p6vkHQ56yD3ieMP6");
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setMultiFactorAuthEnabled(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setIsLocked(1);
        user.setPasswordAlgo("RrEHYCN3JIzu0mFMqhORS5761tPWmHdYJd94VtPGFoUI73nMhP");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458129750186l));
        user.setIsDeleted(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(34046);
        user.setChangePasswordNextLogin(1);
        user.setSessionTimeout(2954);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458129750217l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(2);
        question.setQuestionDetails("bvjEt7g3UH");
        question.setQuestion("g1UkL5l8uWh3cDv0qUxeFELQpQNFLyBaTHDrtkHU21ZyIoGRth");
        question.setQuestionIcon("LbEUx1WNhf2s1J6HW5f1pLyFYxU8uRpSaK6GfBDJqtzFyRjIF6");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setAnswer("xtFmNaaWpldRfs3qlPkjHvJyd1nYLdwCUQqRAQd9cvgwg4XxkJ");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setUser(user);
        userdata.setPassword("TcxAOteU65BsFhu9vqMDQtu9trV2YxJWpCMeFSfRKJsTEPt2Dw");
        userdata.setOneTimePassword("oLT8Dtd8pj2QJZHQa2KoKOoAx4kNs95u");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setLast5Passwords("X2JDm9KMArVy3sUFprASKjWvycz8QDCv99BFhU5CVMqWk97eLE");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458129750395l));
        user.setUserData(userdata);
        Login login = new Login();
        login.setLoginId("o01EYWrJghVfKzyNccJPMI791k7xwTN6pqND8eBarROPFBWaof");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("7NEHkDiEmCjIgRRL");
        login.setFailedLoginAttempts(4);
        login.setServerAuthImage("VY7KDLCHCsyoyI81jdRceHd5oV7m1OFJ");
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin();
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("i8tVODS0B1njdi2lR91wuDcFk3hl0VYP8cyPtuN3qe8y1v5VYc");
            login.setServerAuthText("MR0nMVCj1HRgUuuR");
            login.setFailedLoginAttempts(4);
            login.setServerAuthImage("a8uOmk88YGPlTCOOBdUjz1qHlDCT5cvU");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "rQ9QxPBxStN4cHzYwu1Bh5HhaFoDIPrmGfF649FiD6Lp0Ur1YzPjEWYWyvMkts6vuIWM7iDQCq5enKwezkCraDIf8DEW5u3QCjdX0ThHWQKSXCEferRcRan7y5iMIdnmZSg37RAAW1DbaXKmv01ots3EHQpgIsgTRgjcmzB9TF47WgPxTX8bwOlfnMx6FGBeM6H0H0qpM"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "pBGIXPdc1IO6juLDKOsqoI0VI7WywQyMD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "HMOxiUYETH8soiqx7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 15));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin();
                java.lang.reflect.Field field = login.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
