package com.labs.spring.cloud.transaction.controller;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionControllerTest {

    @Autowired
    TestRestTemplate restTemp;

    @MockBean
    @Autowired
    TransactionService transService;

    private static List<Transaction> transactions = new ArrayList<>();
    
    HttpHeaders headers = new HttpHeaders();

    @BeforeEach
    public void setup() {
        // Initialize Test data
    	Transaction trans1 = new Transaction();
		
    	trans1.setId(1);
    	trans1.setAmount(5000); 
    	trans1.setDescription("testing1");
    	trans1.setFromaccountid(1);
    	trans1.setToaccountid(2);
    	trans1.setStatus("CREATED");
    	trans1.setType("DEBIT");
		transactions.add(trans1);
		transService.add(trans1);
		
		Transaction trans2 = new Transaction();
		trans2.setId(2);
		trans2.setAmount(3000); 
		trans2.setDescription("testing 2");
		trans2.setFromaccountid(1);
		trans2.setToaccountid(2);
		trans2.setStatus("CREATED");
		trans2.setType("CREDIT");
		transactions.add(trans2);
		transService.add(trans2);
    }

    @AfterEach
    public void cleanup() {
    	//transService.clear();
    	transactions.clear();
    }

    @Test
    public void shouldCreateTransaction() throws URISyntaxException
    {
        // POST /products    
        Mockito.when(transService.add(new Transaction())).thenReturn(1);

        String reqBody = "{\"id\":\"1\",\"amount\":\"3000\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"fromaccountid\":\"2\",\"toaccountid\":\"3\"}";

        // Step 1: Create Request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/transactions"));

        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response

        ResponseEntity<String> response = restTemp.exchange(request, String.class);

        System.out.println("Response: " + response.getBody());

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).contains("Transaction Created");
    }

      

    @Test
    public void shouldReturnAllTransactions() {

        Mockito.when(transService.list()).thenReturn(transactions);

        ResponseEntity<Object> response = restTemp.getForEntity("/transactions", Object.class);

        List<Transaction> transactions = (List) response.getBody();

        System.out.println("Response: " + transactions);

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(transactions.size()).isEqualTo(2);
      
    }
    
    @Test
    public void shouldReturnTransactionBasedonGivenId() throws  URISyntaxException {
    	        
    	 String reqBody = "{\"id\":\"1\",\"amount\":\"3000\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"fromaccountid\":\"2\",\"toaccountid\":\"3\"}";
         
         ResponseEntity<Object> response = restTemp.getForEntity("/transactions/1", Object.class);
         System.out.println("Response: " + response.getBody());

         // Step 4: Validate the Response
         Assertions.assertThat(response).isNotNull();              
    }         
    
    
    @Test
    public void shouldUpdateTransaction() throws URISyntaxException 
    {
        // POST /products    
       // Mockito.when(acctService.updateTransaction(1, new Transaction())).thenReturn("Transaction is updated successfully");

        String reqBody = "{\"id\":\"1\",\"amount\":\"3000\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"fromaccountid\":\"2\",\"toaccountid\":\"3\"}";
               
        // Step 1: Create Request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.PUT, new URI("/transactions/1"));

        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response

        ResponseEntity<String> response = restTemp.exchange(request, String.class);

        System.out.println("Response: " + response.getBody());

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).contains("Transaction Updated");
    }
    
    
    @Test
    public void shouldDeleteTransaction() throws URISyntaxException 
    {
        // POST /products    
        String reqBody = "{\"id\":\"1\",\"amount\":\"3000\",\"type\":\"DEBIT\",\"status\":\"CREATED\",\"fromaccountid\":\"2\",\"toaccountid\":\"3\"}";
               
        // Step 1: Create Request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.DELETE, new URI("/transactions/1"));

        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response

        ResponseEntity<String> response = restTemp.exchange(request, String.class);

        System.out.println("Response: " + response.getBody());

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).contains("Transaction Deleted");
    }
    
    
}
