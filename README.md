# ws_router
 wiseconnect router is spring boot API services for performing various Enterprise Data transaformations

 # Installation
# Prerequisites:

Java JDK 11 or later
Maven 3.6.0 or later (if not using Maven Wrapper)
activeMQ 6.0.0
postgres 16.0.0

Steps:

Clone the repository:
bash
Copy code
git clone [(https://github.com/syed-ahamed04/ws_router)https://github.com/syed-ahamed04/ws_router]


# Configuration
Application Configuration
Edit the application.properties or application.yml file under src/main/resources for basic configurations like:

Server port :8092
Security settings
Logging levels
Database Configuration
Configure your database properties such as:

spring.datasource.url: jdbc:postgresql://localhost:5432/postgres
spring.datasource.username: postgres
spring.datasource.password: admin
Additional properties for connection pooling, JPA/Hibernate settings, etc.


# ActiveMQ Configuration
Specify ActiveMQ settings:

spring.activemq.broker-url: (http://localhost:8161/admin/queues.jsp)
spring.activemq.user: admin
spring.activemq.password: Password








# RouterApplication.java as java application



# API Endpoints
Data Transformation Endpoint
URL: /wiseconnect/xmlToActiveMq
Method: POST
Description: Sends the input data to Active MQ


# Request Body: XML format 

{<?xml version="1.0" encoding="UTF-8"?>
<ServiceRequest xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:m="urn:messages.service.ti.apps.tiplus2.misys.com" xmlns="urn:control.services.tiplus2.misys.com" xmlns:c="urn:common.service.ti.apps.tiplus2.misys.com" xmlns:x="urn:custom.service.ti.apps.tiplus2.misys.com">
	<RequestHeader>
		<Service>TI</Service>
		<Operation>TFILCCOR</Operation>
		<Credentials>
			<Name>SUPERVISOR</Name>
			<Password>SUPERVISOR</Password>
			<Certificate>XXX</Certificate>
			<Digest>XXX</Digest>
		</Credentials>
		<ReplyFormat>NONE</ReplyFormat>
		<SourceSystem>CorporateChannels</SourceSystem>
		<NoRepair>N</NoRepair>
		<NoOverride>N</NoOverride>
		<CorrelationId>NONE</CorrelationId>
		<TransactionControl>NONE</TransactionControl>
	</RequestHeader>
	<m:TFILCCOR>
		<m:Context>
			<c:Customer>ABC</c:Customer>
			<c:OurReference>ILC/MBW/11/0025</c:OurReference>
			<c:TheirReference>LC23100000000063</c:TheirReference>
			<c:BehalfOfBranch>LOND</c:BehalfOfBranch>
		</m:Context>
		<m:EventNotificationss>
			<m:EventNotifications>
				<m:MessageData>Name: Admin One
Phone no.: 1234567
Email: iim@sc.com</m:MessageData>
				<m:MessageDescription>Corporate Contact</m:MessageDescription>
				<m:MessageInfo>Additional information</m:MessageInfo>
				<m:Actioned>N</m:Actioned>
			</m:EventNotifications>
		</m:EventNotificationss>
		<m:Sender>
			<c:Reference>LC23100000000063</c:Reference>
		</m:Sender>
		<m:CorresType>G</m:CorresType>
		<m:MessageText>Message from Client:</m:MessageText>
		<m:eBankMasterRef>LC23100000000063</m:eBankMasterRef>
		<m:eBankEventRef>23100200000077</m:eBankEventRef>
	</m:TFILCCOR>
</ServiceRequest>}


# Response: Pushes xml data in ActiveMQ -> Ingress Queue

2) http://localhost:8092/wiseconnect/xmlToDataStore

   transforms the xml data and stores into Database
   Input : <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns5:ServiceRequest xmlns:m="urn:messages.service.ti.apps.tiplus2.misys.com" xmlns:c="urn:common.service.ti.apps.tiplus2.misys.com" xmlns:x="urn:custom.service.ti.apps.tiplus2.misys.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ns5="urn:control.services.tiplus2.misys.com">
    <ns5:RequestHeader>
        <ns5:Service>TI</ns5:Service>
        <ns5:Operation>TFILCAMN</ns5:Operation>
        <ns5:ReplyFormat>NONE</ns5:ReplyFormat>
        <ns5:SourceSystem>CorporateChannels</ns5:SourceSystem>
        <ns5:NoRepair>N</ns5:NoRepair>
        <ns5:NoOverride>N</ns5:NoOverride>
        <ns5:CorrelationId>NONE</ns5:CorrelationId>
        <ns5:TransactionControl>NONE</ns5:TransactionControl>
        <ns5:Credentials>
            <ns5:Name>SUPERVISOR</ns5:Name>
            <ns5:Password>SUPERVISOR</ns5:Password>
            <ns5:Certificate>XXX</ns5:Certificate>
            <ns5:Digest>XXX</ns5:Digest>
        </ns5:Credentials>
    </ns5:RequestHeader>
    <m:TFILCAMN>
        <m:Context>
            <c:Customer>401</c:Customer>
            <c:OurReference>ILC/MBW/11/0025</c:OurReference>
            <c:TheirReference>LC23100000000063</c:TheirReference>
            <c:BehalfOfBranch>LOND</c:BehalfOfBranch>
        </m:Context>
    </m:TFILCAMN>
</ns5:ServiceRequest>


Output: stores into  table xml_storage.transactional_xml

1  <?xml version="1.0" encoding="UTF-8"?>
<select_from_xml_storage_transactional_xml>
  <DATA_RECORD>
    <id>6654805a-ba08-481f-925d-9a745f82ff69</id>
    <xml_data>&lt;?xml version="1.0" encoding="UTF-8" standalone="yes"?&gt;
&lt;ns5:ServiceRequest xmlns:ns5="urn:control.services.tiplus2.misys.com" xmlns:c="urn:common.service.ti.apps.tiplus2.misys.com" xmlns:x="urn:custom.service.ti.apps.tiplus2.misys.com" xmlns:m="urn:messages.service.ti.apps.tiplus2.misys.com" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"&gt;
    &lt;ns5:RequestHeader&gt;
        &lt;ns5:Service&gt;TI&lt;/ns5:Service&gt;
        &lt;ns5:Operation&gt;TFILCAMN&lt;/ns5:Operation&gt;
        &lt;ns5:ReplyFormat&gt;NONE&lt;/ns5:ReplyFormat&gt;
        &lt;ns5:SourceSystem&gt;CorporateChannels&lt;/ns5:SourceSystem&gt;
        &lt;ns5:NoRepair&gt;N&lt;/ns5:NoRepair&gt;
        &lt;ns5:NoOverride&gt;N&lt;/ns5:NoOverride&gt;
        &lt;ns5:CorrelationId&gt;NONE&lt;/ns5:CorrelationId&gt;
        &lt;ns5:TransactionControl&gt;NONE&lt;/ns5:TransactionControl&gt;
    &lt;/ns5:RequestHeader&gt;
&lt;/ns5:ServiceRequest&gt;
</xml_data>
    <status>Processed</status>
    <created_user>truser01</created_user>
    <updated_user></updated_user>
    <created_at>2023-12-11 12:26:22.370 +0530</created_at>
    <updated_at>2023-12-11 12:26:22.370 +0530</updated_at>
  </DATA_RECORD>
</select_from_xml_storage_transactional_xml>







