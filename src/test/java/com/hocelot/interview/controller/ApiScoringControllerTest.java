package com.hocelot.interview.controller;

//@WebMvcTest(ApiScoringControllerImpl.class)
public class ApiScoringControllerTest {

    /*@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiScoreService apiScoreService;

    @MockBean
    private RedisService redisService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {  objectMapper = new ObjectMapper();  }

    private final String headerUserName = "tdsadasdsa";
    private final String countryCode = "MX";


    @Test
    void test200() throws Exception {
        // GIVEN
        when(apiScoreService.callScoreService(any(String.class), any(String.class), any(InterviewTestRequest.class), any(Boolean.class)))
                .thenReturn(
                        (ScoreResponse) getObjectResponseCustom("services","response1.json", ScoreResponse.class)
                );

        // WHEN
        InterviewTestRequest requestController = (InterviewTestRequest) getObjectRequestCustom("request-controller-1.json", InterviewTestRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/dasdas/4564/dsadas")
                .contentType(MediaType.APPLICATION_JSON)
                        .header("Country-Code", countryCode).header("User-Id", headerUserName)
                .content(objectMapper.writeValueAsString(requestController))
        )
        // THEN
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.decission").value("A"))
                .andExpect(jsonPath("$.operationId").value("HocelotTest1"))
                .andExpect(jsonPath("$.traceId").value("373f03af873a245b"));

        //.andExpect(content().json(objectMapper.writeValueAsString(response)));

    }*/

}