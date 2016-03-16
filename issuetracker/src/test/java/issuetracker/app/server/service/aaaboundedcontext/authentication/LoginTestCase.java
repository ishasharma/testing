package issuetracker.app.server.service.aaaboundedcontext.authentication;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.Login;
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
import issuetracker.app.shared.aaaboundedcontext.authentication.User;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.PassRecovery;
import issuetracker.app.shared.aaaboundedcontext.authentication.Question;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserData;
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Timezone;
import issuetracker.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Title;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Gender;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Language;
import issuetracker.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Country;
import issuetracker.app.server.repository.organizationboundedcontext.location.CountryRepository;
import issuetracker.app.shared.organizationboundedcontext.location.City;
import issuetracker.app.server.repository.organizationboundedcontext.location.CityRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.AddressType;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationType;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
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
        User user = new User();
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("2KJyO876gW52inWb2TmxYum2pEOztieNdZuoS0iwJyBO5giR9E");
        user.setGenTempOneTimePassword(1);
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("9G1GNWxBin8TRGoQTOuuJzV3azLcPSSfYlsY3uHDHUylwXlyok");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("nlbC0yLEL3SpW9EPqXkDypPPBuULGV9MWAcaroRBg2CCF0xLQK");
        useraccessdomain.setDomainName("U7ChkPSd3tSV0htI9Ey9fcUelMhRtOFY87fZN5vPAdaHl5nrtG");
        useraccessdomain.setDomainDescription("UvNgFfDZEmH5DptGooE2Bs6ocCLRqDEE4fG6N1PDL5urmsYpuo");
        UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
        map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("cVdD2WCLWQNwvxgkJRUfUGJFsorQse1lsmpDW4N4DhVlglC8Uc");
        useraccesslevel.setLevelName("iObkmc4nrg6EB2yqlA1mzoQHOHOFmDUwOpFYEsqxemNV9vZuIl");
        useraccesslevel.setLevelDescription("npR0i6WfHWrz6H2L6S6MbtFcSWlFyJRfs0FEvzWDo3yYmcbEqc");
        useraccesslevel.setLevelIcon("vqZqVXKYMu9ozoFJzK6FZ3QpFlikqlA6LU7gotrNMcEvuvGGCt");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
        map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        user.setChangePasswordNextLogin(1);
        user.setPasswordAlgo("63zIyDgfYYXdm0bE0q1BRFdqNbOjvSrDZvUtSHlPKDUf9VIxBq");
        user.setGenTempOneTimePassword(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setAllowMultipleLogin(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsDeleted(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1458127859610l));
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1458127859645l));
        user.setSessionTimeout(2175);
        user.setUserAccessCode(16343);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("gDVcEwaI2W");
        question.setLevelid(11);
        question.setQuestionIcon("LdXiobjAcykqRbhHkVFKPcz4nME7bky9X8oXEDNbosBa2H0lSm");
        question.setQuestion("1vIIlmi1i4NLY33e19UgL0z5z1exGIhPHer8OQe501ddalL4vC");
        Question QuestionTest = questionRepository.save(question);
        map.put("QuestionPrimaryKey", question._getPrimarykey());
        passrecovery.setUser(user);
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("lAlUvbUb9cu1bFMtd7q5rGc2BX9InYe4hsJXXyTR1Yq0QdpoOs");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(3);
        userdata.setLast5Passwords("JwsufTKiClo05ZQIl62mUkhN9iEnorJ1pKU3SVqB5FRwQnROrd");
        userdata.setOneTimePasswordExpiry(7);
        userdata.setLast5Passwords("wD62lZYoZkvFyUK9hviEt7f92HS8Lbh8xtnC2WbbNV3Bb4mOy6");
        userdata.setUser(user);
        userdata.setPassword("oMK3cVZEuDRfd7gog2yB5wVcSLL5kmOcRN9MP4nMlK0YoOUigh");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1458127859816l));
        userdata.setOneTimePassword("X2azts4ZoExmL7bz9jO73dSTn3omzD23");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("awE1CgC9FPXRz7zPwFOE9QuxuSQ3jplFlxSHlQmHh43s9hTlwh");
        corecontacts.setMiddleName("Zke8muxxIITUSadV22aLh20A5OIyCJvsxtH0Nqf9daijeujsxR");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("KMYD45WOl0zM1MKKvKOEJ6JxMVFLv6ltt686XeU8eCuDXtDKOf");
        timezone.setTimeZoneLabel("xrtIvfB8CtS80ovVE6W6KHUAefmgUq8KhKuKP44eNU1UNHMJU8");
        timezone.setCountry("8T9Wdd77hnEyM4umiTmnxFBsgfzC58ilV0CjX36kovJSVNwFzU");
        timezone.setCities("sa2IUI6b6b5yWcQwQRFY5STYuQdc7GEPX8Wf6Jyp4VevTEVtro");
        timezone.setUtcdifference(4);
        Title title = new Title();
        title.setTitles("QMHQVWED9c1AXNNg7vNjTM8XfFXe86IQXcsoGdrYDgQihQSEQl");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("5mwRixhKTBvVUPIhzuXzjUSt06LU7mE1HBgRCZRlckKqwGZkp5");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("rqEXuVc8IkvI5M0GQdQhqRa4AOcFfa9h19ft9DJSu5fS7IiNPA");
        language.setAlpha4parentid(7);
        language.setAlpha2("f6");
        language.setLanguageIcon("WSNBYIUdJAvRSwqSjzsSrN9ENmU4t9n1TUwDqMW5fVIIEklPSd");
        language.setAlpha4("QHH6");
        language.setAlpha3("Rvg");
        language.setLanguageType("Dmncavv9CiRhlGuIBKGf5QPDs3D9hXEN");
        language.setLanguageDescription("HFrno2mv7sL8HQGinvYILfZzsAOuo4Er926loMDIuZZfqJqNmQ");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("IoUaEtvJaYevRPo3s4gRnAlTlxjVZipf0hsn7peaDwQ7fr6XL6");
        corecontacts.setMiddleName("FVM2xQ4sgGZW8qeHzLKyKoo0raUubIDe5o9X6zJ3x17tiVoRDq");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("uuLj3vz5kfCqAikBSlssBw4cU2BbKak3aFSAjPfdrwKABcMdSg");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127859927l));
        corecontacts.setAge(60);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("qSmYTK4VdJhcn0C81JDlHGzgJiI9tBWJJEpxPqqL0CkcIm9PfL");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("cy8iQilNcolBaXwiA0uNvx9oHmtsnToTPN5DiHRrRLyoaVV49A");
        corecontacts.setPhoneNumber("JfTAXIkphN2S0Nu3gqGl");
        corecontacts.setEmailId("eWWaAWTJYYdHGgs3hwshLngkL1LZ7BPe6FDZ42azAHuighjW7L");
        corecontacts.setNativeMiddleName("kAKP5P12x8rK4k1TSeYcmkern4ZJGdu5x8FxghBRfYAvoAdRli");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127860009l));
        corecontacts.setNativeTitle("OZi1ctitF4m4lZUN1smKKztTemi7GkSWWtCLR81rmDwkU7iDvS");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("2H8VL3OoUj47LycGtO4LttXpmTwQDcKbd2E6Q3OZ5gTnPCghU4");
        country.setCountryCode1("HuT");
        country.setCapitalLongitude(5);
        country.setCurrencyName("L1EC2cI6Raneo3TvySMafeLstX0aPvwNJXbD6HgT01db6jzgsP");
        country.setCurrencyCode("vo7");
        country.setCountryFlag("9WMQIY4nxKe4Vk9fV2ofJjXsFteNrByHm3Ws1xt8RPubMNtKG8");
        country.setIsoNumeric(8);
        country.setCapitalLatitude(5);
        country.setCapital("btMg7YQ4l1268ncTbGQJnt081GzOcsSt");
        country.setCountryCode2("HDo");
        country.setCurrencySymbol("uMdCT61UcnjQGZfJu3OjE4N8UK7OtKrl");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("g8QKXoPwUq2s5rf23dHl02mkimKLx4xkYv7vA46STxmnw5fgzf");
        city.setCityLongitude(8);
        city.setCityLatitude(6);
        city.setCityDescription("mqxOQ7x6ZxOmawNSKMsGGURhM5JcgHXJi9T3ZfoJ8Q7icN47rX");
        city.setCityCode(3);
        city.setCityName("FogbSbNdYMDXxqGWmlQu7hERvCqHTlUtmjnpYElWgm7uRnxolK");
        State state = new State();
        state.setStateCodeChar2("ntIIkNMyApdbhMJDj1Nqy8WwGpDnKgH4");
        state.setStateCapitalLongitude(7);
        state.setStateCodeChar3("CZ9Mt14n2LrNGeStvsJpwnD5hPComFxe");
        state.setStateCodeChar2("YbgyWuA2zHL07YMulFVb0ztUndExA9vK");
        state.setStateCapitalLongitude(4);
        state.setStateCodeChar3("6L65jxoi1LPCLhmPwn7mCHQkeXCuGOsb");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("1Uqzn6Oz18mkzJOCNMPyVRWmLaZgqgxKnfzKBlCg2yuIHP1MIX");
        state.setStateFlag("QbM7jYLJFVZ5moEjHB3ETIUZarLcCE2v2gbCbUQqv8ILcSDgZO");
        state.setStateCapital("lx7eP49vRRfBFRxLUo6FTIhib1BIFrPf4dphMSOOaC1ssEIIi9");
        state.setStateCapitalLatitude(10);
        state.setStateDescription("ajdMyKWUcPzBcIeNvpWx0OlDS38azBOdSDOSdfKTxqFWhRbTFp");
        state.setStateCode(1);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("ZrzCAsM8sioY7dseHTN6d95xxOosPB7uaOVvEkSWrph8DfXcrm");
        city.setCityLongitude(3);
        city.setCityLatitude(4);
        city.setCityDescription("vkFDQoKVP5Fza2tNb45qDJgywZWCnOPoiHpFmGzMG8z0zXSSjs");
        city.setCityCode(1);
        city.setCityName("mzKL2eVyt1twNB2s3JJl3zjhv39gyVXTJepw3GfljPodYfJzl9");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("kR7QVWu8mZQAWl2JxZtt0S2lmq82xMBd");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("TaGUS2wlpZXekteYGHhR1btf3zB2kZ5x1Jv2tKyNGWwSuRzqyy");
        addresstype.setAddressTypeDesc("8FNe2nLbBN6v8ZznynLK2whUvTnrxuXT1plQWIUgLBZZQ9a1av");
        addresstype.setAddressType("WhnFMM2DPil7lb5rwZlpahLS9QEzBZ2ye7XHmlMge6VaeRXN47");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("QLMoY1KmB6qAlBzJqA0Bpn53FwZ0ouBgIOzJUh2fwMTTMXUU01");
        address.setAddress1("Uyr7O8wIjWbtXZLcvpnJAqI0Zwcd86mTCPCJr3BN8XXfGi9YVB");
        address.setLatitude("Crmvv5UoZTBEXYXnKQ7NbliW2176gJpUBZSpPxomy0hSTPHkw7");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("3oVnwk");
        address.setAddress2("Vu5kUQnJtFqN698gpld8H88Ozm2Ftj4GjGX6BpbgV0AnP9dPp6");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("vkRMlMqyyZf");
        address.setAddress3("prIXiOOtZf1pqp23QAJiND9o3zfbg56brodsaOfR4paiBrP4gW");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("by4tLzXPBD4TJU1NCpJHYy5yBTN9Ub3GpWQFn3XmmauI88QDdm");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("fNlt8Q2GFphqihMUeibATYE6lFEsRXJlaa2jakeSYrSuRCvXSE");
        communicationgroup.setCommGroupName("n8KkIB0Nt6Yi1NqFNqMPTFF788KZg8NTAZcMfIOQm2Ojz5Vexa");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("z4UsyPECEmqMEd7OQe7heRJhdcqF5l5aczknSzapOhf7X3zULb");
        communicationtype.setCommTypeName("Dr4WgdEeU0KkraT4ptwSz6j7t2Ec8YTglVTlllH1zenWqzBTkT");
        communicationtype.setCommTypeDescription("2fAAXTQde8N13fLrAlqhf8BkAYVZE701v1RCDXg1kMd03cj5yb");
        communicationtype.setCommTypeName("rshPmtopuXGniBOIr03p6Ky7dJ9banMXwUZiJBpp5uU7O72M9z");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("Hr3sTMo3ShoT0Zt69R8ivzhCXPhEugCzii9d0yHy5sSXDocO7H");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        login.setLoginId("7vlMIxaaBbZPuim2plNaHklMFISimDbfBKRV9ZPvhZhP28075X");
        user.setUserId(null);
        login.setUser(user);
        login.setFailedLoginAttempts(5);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setIsAuthenticated(true);
        login.setServerAuthImage("9o4FaF9YqTefewWtXaZfnwRJ1vmLgR0V");
        login.setServerAuthText("TMQOyewMwljD57Hm");
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
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("IaoQBoKg9kvrDT2x5SB3BxPb2FulCIzAmsQGVsC7nuXfk8IiII");
            login.setVersionId(1);
            login.setFailedLoginAttempts(1);
            login.setServerAuthImage("fSwHCcdrNNAb3uGoTNq91xj1odnXYA8k");
            login.setServerAuthText("5X5owd2Au3sxC1sT");
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
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "hjkATDtmAtFspkrBXCKVUFsBb2iBeYWnLyqpKTcuhQ5kmcXcJ5cH4oXuTDn7GO82KY7wOp6JP11IVkfDislef7Az5mWcXR37RztLrQPX20cE8NL443coyvbCMa6jQpMTsWTUL7xH9cmPjumWNGgqxjoACNGs2TnObyaDobaLPbFTyUhdByrtBVLeFNm5zfoAAl9bicwe1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "Pr0FaP1wnA35X9IdVL9l0JYYS9u3nVdaS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "ekkX7DjWIOLJYqjd6"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 17));
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
