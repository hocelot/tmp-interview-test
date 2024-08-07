package com.hocelot.interview.service;

//@SpringBootTest
//@ContextConfiguration
public class ApiScoreServiceTest {
    /*
    @Autowired
    private ApiScoreService apiScoreService;

    @MockBean
    private EnrichmentService enrichmentService;

    @MockBean
    private ScoringModelClient scoringModelClient;


    @MockBean
    private AuditDataClient auditDataClient;

    @MockBean
    private RedisService redisService;

    @Autowired
    private Tracer tracer;  //for Test 5a & 5b

    @MockBean
    private Span mockSpan;  //for Test 5a & 5b


    @BeforeEach
    public void setUp(){
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void test_1() throws IOException {
        // GIVEN: given a test environment
        when(redisService.saveDocumentNumber(any()))
                .thenReturn((DocNumRedisDTO) getObjectResponseCustom("redis", "request1.json", DocNumRedisDTO.class));
        when(enrichmentService.invokeEnrichment(any(), any()))
                .thenReturn((EnrichmentResponse) getObjectResponseCustom("enrichment", "enrichmentResponse1.json", EnrichmentResponse.class));
        when(scoringModelClient.getScore(anyList()))
                .thenReturn(ResponseEntity.ok().body(BigDecimal.valueOf(0.08748287707567215)));
        when(auditDataClient.auditEnrichment(any(EnrichmentResponse.class)))
                .thenReturn(ResponseEntity.ok(null));
        when(auditDataClient.auditAcceptedDeniedRequest(any(AccDenRequest.class)))
                .thenReturn(ResponseEntity.ok(null));
        when(auditDataClient.auditFindRequest(any(AudForRequest.class)))
                .thenReturn(ResponseEntity.ok(null));

        // WHEN: when we execute the method to test
        ScoreResponse scoreResponse = apiScoreService.callScoreService("MX", "dasdasdsa",
                (InterviewTestRequest) getObjectRequestCustom("request-1.json", InterviewTestRequest.class), Boolean.FALSE);

        // THEN: valid
        ScoreResponse response = (ScoreResponse) getObjectResponseCustom("api", "response1.json", ScoreResponse.class);
        assertNotNull(scoreResponse);
        //assertEquals(scoreResponse, response);
        assertEquals(response.getDecission(), scoreResponse.getDecission());
        assertEquals(response.getOperationId(), scoreResponse.getOperationId());
        assertEquals(response.getTraceId(), scoreResponse.getTraceId());

    }*/


}