package ir.rahyabcp.collector.api.datanodelist;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.api.datanodelist.dto.DataNodeListResponse;
import ir.rahyabcp.collector.api.datanodelist.dto.FtpPropertiesDto;
import ir.rahyabcp.collector.api.datanodelist.dto.RdbPropertiesDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataNodeListResponseDeserializationTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }
    
    
    @Test
    void whenValidJson_thenDeserializeSuccessfully() throws Exception {
        DataNodeListResponse result = objectMapper.readValue(sampleJsonResponse(), DataNodeListResponse.class);

        assertNotNull(result);
        assertNotNull(result.getResponseHeader());
        assertNotNull(result.getResponseBody());

        assertEquals("0", result.getResponseHeader().messageCode());
        assertEquals("OK", result.getResponseHeader().messageText());
        assertEquals("20250507095613", result.getResponseHeader().sysDate());
        assertEquals("text/html; charset=UTF-8", result.getResponseHeader().encoding());

        var dataNodes = result.getResponseBody().data();
        assertEquals(4, dataNodes.size());

        // First Node
        var firstNode = dataNodes.getFirst();
        assertEquals(1008, firstNode.dataNodeId());
        assertEquals("Virtual Node", firstNode.dataNodeName());
        assertEquals("ACTIVE", firstNode.dataNodeStatus());
        assertEquals("CONTENT", firstNode.contentMode());
        assertEquals("FTP", firstNode.protocol());

        FtpPropertiesDto firstNodeProps = (FtpPropertiesDto) firstNode.extendedProperties();
        assertNotNull(firstNodeProps);
        assertEquals("10.20.30.40", firstNodeProps.getFtpSourceIpv4());
        assertEquals("/tic/data/src", firstNodeProps.getFtpSourcePath());
        assertEquals(".*CDR", firstNodeProps.getFtpSourceMask());
        assertEquals("/tic/data/dst", firstNodeProps.getFtpDestinationPath());
        assertEquals("uu", firstNodeProps.getFtpUsername());
        assertEquals("pp", firstNodeProps.getFtpPassword());
        assertEquals(10, firstNodeProps.getFtpSegmentSize());
        assertEquals(900, firstNodeProps.getFtpPollingInterval());

        // Second Node
        var secondNode = dataNodes.get(1);
        assertEquals(1001, secondNode.dataNodeId());
        assertEquals("ISC1", secondNode.dataNodeName());
        assertEquals("ACTIVE", secondNode.dataNodeStatus());
        assertEquals("NULL", secondNode.contentMode());
        assertEquals("FTP", secondNode.protocol());
        assertNull(secondNode.extendedProperties());

        // Third Node
        var thirdNode = dataNodes.get(2);
        assertEquals(1002, thirdNode.dataNodeId());
        assertEquals("ISC2", thirdNode.dataNodeName());
        assertEquals("ACTIVE", thirdNode.dataNodeStatus());
        assertEquals("NULL", thirdNode.contentMode());
        assertEquals("FTP", thirdNode.protocol());

        FtpPropertiesDto thirdNodeProps = (FtpPropertiesDto) thirdNode.extendedProperties();
        assertNotNull(thirdNodeProps);
        assertEquals("192.168.128.2", thirdNodeProps.getFtpSourceIpv4());
        assertEquals("/ISC1", thirdNodeProps.getFtpSourcePath());
        assertEquals("CDR$", thirdNodeProps.getFtpSourceMask());
        assertEquals("/home/ticuser/isc1", thirdNodeProps.getFtpDestinationPath());
        assertEquals("U", thirdNodeProps.getFtpUsername());
        assertEquals("", thirdNodeProps.getFtpPassword());
        assertEquals(10, thirdNodeProps.getFtpSegmentSize());
        assertEquals(1800, thirdNodeProps.getFtpPollingInterval());

        // Fourth Node
        var fourthNode = dataNodes.get(3);
        assertEquals(1003, fourthNode.dataNodeId());
        assertEquals("ISC3", fourthNode.dataNodeName());
        assertEquals("ACTIVE", fourthNode.dataNodeStatus());
        assertEquals("NULL", fourthNode.contentMode());
        assertEquals("RDB", fourthNode.protocol());

        RdbPropertiesDto fourthNodeProps = (RdbPropertiesDto) fourthNode.extendedProperties();
        assertNotNull(fourthNodeProps);
        assertEquals("jdbc:oracle:thin:@//172.16.65.100:1521/sabapadb", fourthNodeProps.getRdbConnectionString());
        assertEquals("ORACLE", fourthNodeProps.getRdbDbType());
        assertEquals("mrpua", fourthNodeProps.getRdbUsername());
        assertEquals("mrpua", fourthNodeProps.getRdbPassword());
        assertEquals("SELECT cparty_id, cparty_fullname FROM amtcparties", fourthNodeProps.getRdbDatasource());

        // Data Format assertions (checking first node as example)
        var dataFormat = firstNode.dataFormat();
        assertNotNull(dataFormat);
        assertEquals(1000, dataFormat.fileFormatId());
        assertEquals("Internet Database Format", dataFormat.fileFormatName());
        assertEquals(";", dataFormat.fieldDelimiter());
        assertEquals("RECORD", dataFormat.contentType());

        var formatItems = dataFormat.fileFormatItems();
        assertEquals(8, formatItems.size());

        var firstItem = formatItems.getFirst();
        assertEquals(1066, firstItem.fileFormatItemId());
        assertEquals("EDR_ID", firstItem.fileFormatItemName());
        assertEquals("NUMBER", firstItem.dataType());
        assertNull(firstItem.dataFormat());
        assertNull(firstItem.dataLength());
        assertNull(firstItem.valMin());
        assertNull(firstItem.valMax());
        assertNull(firstItem.isRequired());
        assertEquals(1, firstItem.orderNo());
        assertEquals("EDR_ID", firstItem.internalName());
        assertNull(firstItem.description());

        var secondItem = formatItems.get(1);
        assertEquals(1067, secondItem.fileFormatItemId());
        assertEquals("BEGIN_TIME", secondItem.fileFormatItemName());
        assertEquals("DATE", secondItem.dataType());
        assertNull(secondItem.dataFormat());
        assertNull(secondItem.dataLength());
        assertNull(secondItem.valMin());
        assertNull(secondItem.valMax());
        assertNull(secondItem.isRequired());
        assertEquals(3, secondItem.orderNo());
        assertEquals("EVENT_BEGINDATE", secondItem.internalName());
        assertNull(secondItem.description());

        var thirdItem = formatItems.get(2);
        assertEquals(1068, thirdItem.fileFormatItemId());
        assertEquals("EVENT_TIME", thirdItem.fileFormatItemName());
        assertEquals("NUMBER", thirdItem.dataType());
        assertNull(thirdItem.dataFormat());
        assertNull(thirdItem.dataLength());
        assertNull(thirdItem.valMin());
        assertNull(thirdItem.valMax());
        assertNull(thirdItem.isRequired());
        assertEquals(5, thirdItem.orderNo());
        assertEquals("EVENT_TIME", thirdItem.internalName());
        assertNull(thirdItem.description());

        var fourthItem = formatItems.get(3);
        assertEquals(1064, fourthItem.fileFormatItemId());
        assertEquals("SSID", fourthItem.fileFormatItemName());
        assertEquals("VARCHAR2", fourthItem.dataType());
        assertNull(fourthItem.dataFormat());
        assertNull(fourthItem.dataLength());
        assertNull(fourthItem.valMin());
        assertNull(fourthItem.valMax());
        assertNull(fourthItem.isRequired());
        assertEquals(53, fourthItem.orderNo());
        assertEquals("FIELDV01", fourthItem.internalName());
        assertEquals("کد بیست و پنج رقمی", fourthItem.description());

        var fifthItem = formatItems.get(4);
        assertEquals(1065, fifthItem.fileFormatItemId());
        assertEquals("PORT_NO", fifthItem.fileFormatItemName());
        assertEquals("VARCHAR2", fifthItem.dataType());
        assertNull(fifthItem.dataFormat());
        assertNull(fifthItem.dataLength());
        assertNull(fifthItem.valMin());
        assertNull(fifthItem.valMax());
        assertNull(fifthItem.isRequired());
        assertEquals(71, fifthItem.orderNo());
        assertEquals("FIELDV03", fifthItem.internalName());
        assertNull(fifthItem.description());

        var sixthItem = formatItems.get(5);
        assertEquals(1069, sixthItem.fileFormatItemId());
        assertEquals("DOWNLOAD", sixthItem.fileFormatItemName());
        assertEquals("NUMBER", sixthItem.dataType());
        assertNull(sixthItem.dataFormat());
        assertNull(sixthItem.dataLength());
        assertNull(sixthItem.valMin());
        assertNull(sixthItem.valMax());
        assertNull(sixthItem.isRequired());
        assertEquals(81, sixthItem.orderNo());
        assertEquals("FIELDN03", sixthItem.internalName());
        assertNull(sixthItem.description());

        var seventhItem = formatItems.get(6);
        assertEquals(1070, seventhItem.fileFormatItemId());
        assertEquals("UPLOAD", seventhItem.fileFormatItemName());
        assertEquals("NUMBER", seventhItem.dataType());
        assertNull(seventhItem.dataFormat());
        assertNull(seventhItem.dataLength());
        assertNull(seventhItem.valMin());
        assertNull(seventhItem.valMax());
        assertNull(seventhItem.isRequired());
        assertEquals(82, seventhItem.orderNo());
        assertEquals("FIELDN04", seventhItem.internalName());
        assertNull(seventhItem.description());

        var eighthItem = formatItems.get(7);
        assertEquals(1071, eighthItem.fileFormatItemId());
        assertEquals("RECORD_TYPE", eighthItem.fileFormatItemName());
        assertEquals("VARCHAR2", eighthItem.dataType());
        assertNull(eighthItem.dataFormat());
        assertNull(eighthItem.dataLength());
        assertNull(eighthItem.valMin());
        assertNull(eighthItem.valMax());
        assertNull(eighthItem.isRequired());
        assertEquals(90, eighthItem.orderNo());
        assertEquals("TTYPE", eighthItem.internalName());
        assertNull(eighthItem.description());
    }
    

    private String sampleJsonResponse() {
        return """
                {
                    "response_header": {
                        "message_code": "0",
                        "message_text": "OK",
                        "sysdate": "20250507095613",
                        "encoding": "text/html; charset=UTF-8"
                    },
                    "response_body": {
                        "data": [
                            {
                                "datanode_id": 1008,
                                "datanode_name": "Virtual Node",
                                "datanode_status": "ACTIVE",
                                "dc_contentmode": "CONTENT",
                                "dc_protocol": "FTP",
                                "description": null,
                                "extende_properties": {
                                    "ftp_source_ipv4": "10.20.30.40",
                                    "ftp_source_path": "/tic/data/src",
                                    "ftp_source_mask": ".*CDR",
                                    "ftp_destination_path": "/tic/data/dst",
                                    "ftp_username": "uu",
                                    "ftp_password": "pp",
                                    "ftp_segment_size": 10,
                                    "ftp_polling_interval": 900
                                },
                                "dataformat": {
                                    "fileformat_id": 1000,
                                    "fileformat_name": "Internet Database Format",
                                    "record_delimiter": null,
                                    "field_delimiter": ";",
                                    "content_type": "RECORD",
                                    "fileformatitems_regex": null,
                                    "description": null,
                                    "fileformatitems": [
                                        {
                                            "fileformatitem_id": 1066,
                                            "fileformatitem_name": "EDR_ID",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 1,
                                            "internal_name": "EDR_ID",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1067,
                                            "fileformatitem_name": "BEGIN_TIME",
                                            "data_type": "DATE",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 3,
                                            "internal_name": "EVENT_BEGINDATE",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1068,
                                            "fileformatitem_name": "EVENT_TIME",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 5,
                                            "internal_name": "EVENT_TIME",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1064,
                                            "fileformatitem_name": "SSID",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 53,
                                            "internal_name": "FIELDV01",
                                            "description":"کد بیست و پنج رقمی"
                                        },
                                        {
                                            "fileformatitem_id": 1065,
                                            "fileformatitem_name": "PORT_NO",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 71,
                                            "internal_name": "FIELDV03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1069,
                                            "fileformatitem_name": "DOWNLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 81,
                                            "internal_name": "FIELDN03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1070,
                                            "fileformatitem_name": "UPLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 82,
                                            "internal_name": "FIELDN04",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1071,
                                            "fileformatitem_name": "RECORD_TYPE",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 90,
                                            "internal_name": "TTYPE",
                                            "description": null
                                        }
                                    ]
                                }
                            },
                            {
                                "datanode_id": 1001,
                                "datanode_name": "ISC1",
                                "datanode_status": "ACTIVE",
                                "dc_contentmode": "NULL",
                                "dc_protocol": "FTP",
                                "description": null,
                                "extende_properties": null,
                                "dataformat": {
                                    "fileformat_id": 1000,
                                    "fileformat_name": "Internet Database Format",
                                    "record_delimiter": null,
                                    "field_delimiter": ";",
                                    "content_type": "RECORD",
                                    "fileformatitems_regex": null,
                                    "description": null,
                                    "fileformatitems": [
                                        {
                                            "fileformatitem_id": 1066,
                                            "fileformatitem_name": "EDR_ID",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 1,
                                            "internal_name": "EDR_ID",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1067,
                                            "fileformatitem_name": "BEGIN_TIME",
                                            "data_type": "DATE",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 3,
                                            "internal_name": "EVENT_BEGINDATE",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1068,
                                            "fileformatitem_name": "EVENT_TIME",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 5,
                                            "internal_name": "EVENT_TIME",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1064,
                                            "fileformatitem_name": "SSID",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 53,
                                            "internal_name": "FIELDV01",
                                            "description":"کد بیست و پنج رقمی"
                                        },
                                        {
                                            "fileformatitem_id": 1065,
                                            "fileformatitem_name": "PORT_NO",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 71,
                                            "internal_name": "FIELDV03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1069,
                                            "fileformatitem_name": "DOWNLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 81,
                                            "internal_name": "FIELDN03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1070,
                                            "fileformatitem_name": "UPLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 82,
                                            "internal_name": "FIELDN04",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1071,
                                            "fileformatitem_name": "RECORD_TYPE",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 90,
                                            "internal_name": "TTYPE",
                                            "description": null
                                        }
                                    ]
                                }
                            },
                            {
                                "datanode_id": 1002,
                                "datanode_name": "ISC2",
                                "datanode_status": "ACTIVE",
                                "dc_contentmode": "NULL",
                                "dc_protocol": "FTP",
                                "description": null,
                                "extende_properties": {
                                    "ftp_source_ipv4": "192.168.128.2",
                                    "ftp_source_path": "/ISC1",
                                    "ftp_source_mask": "CDR$",
                                    "ftp_destination_path": "/home/ticuser/isc1",
                                    "ftp_username": "U",
                                    "ftp_password": "",
                                    "ftp_segment_size": 10,
                                    "ftp_polling_interval": 1800
                                },
                                "dataformat": {
                                    "fileformat_id": 1000,
                                    "fileformat_name": "Internet Database Format",
                                    "record_delimiter": null,
                                    "field_delimiter": ";",
                                    "content_type": "RECORD",
                                    "fileformatitems_regex": null,
                                    "description": null,
                                    "fileformatitems": [
                                        {
                                            "fileformatitem_id": 1066,
                                            "fileformatitem_name": "EDR_ID",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 1,
                                            "internal_name": "EDR_ID",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1067,
                                            "fileformatitem_name": "BEGIN_TIME",
                                            "data_type": "DATE",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 3,
                                            "internal_name": "EVENT_BEGINDATE",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1068,
                                            "fileformatitem_name": "EVENT_TIME",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 5,
                                            "internal_name": "EVENT_TIME",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1064,
                                            "fileformatitem_name": "SSID",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 53,
                                            "internal_name": "FIELDV01",
                                            "description":"کد بیست و پنج رقمی"
                                        },
                                        {
                                            "fileformatitem_id": 1065,
                                            "fileformatitem_name": "PORT_NO",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 71,
                                            "internal_name": "FIELDV03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1069,
                                            "fileformatitem_name": "DOWNLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 81,
                                            "internal_name": "FIELDN03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1070,
                                            "fileformatitem_name": "UPLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 82,
                                            "internal_name": "FIELDN04",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1071,
                                            "fileformatitem_name": "RECORD_TYPE",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 90,
                                            "internal_name": "TTYPE",
                                            "description": null
                                        }
                                    ]
                                }
                            },
                            {
                                "datanode_id": 1003,
                                "datanode_name": "ISC3",
                                "datanode_status": "ACTIVE",
                                "dc_contentmode": "NULL",
                                "dc_protocol": "RDB",
                                "description": null,
                                "extende_properties": {
                                    "rdb_connection_string": "jdbc:oracle:thin:@//172.16.65.100:1521/sabapadb",
                                    "rdb_db_type": "ORACLE",
                                    "rdb_username": "mrpua",
                                    "rdb_password": "mrpua",
                                    "rdb_datasource": "SELECT cparty_id, cparty_fullname FROM amtcparties"
                                },
                                "dataformat": {
                                    "fileformat_id": 1000,
                                    "fileformat_name": "Internet Database Format",
                                    "record_delimiter": null,
                                    "field_delimiter": ";",
                                    "content_type": "RECORD",
                                    "fileformatitems_regex": null,
                                    "description": null,
                                    "fileformatitems": [
                                        {
                                            "fileformatitem_id": 1066,
                                            "fileformatitem_name": "EDR_ID",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 1,
                                            "internal_name": "EDR_ID",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1067,
                                            "fileformatitem_name": "BEGIN_TIME",
                                            "data_type": "DATE",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 3,
                                            "internal_name": "EVENT_BEGINDATE",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1068,
                                            "fileformatitem_name": "EVENT_TIME",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 5,
                                            "internal_name": "EVENT_TIME",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1064,
                                            "fileformatitem_name": "SSID",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 53,
                                            "internal_name": "FIELDV01",
                                            "description":"کد بیست و پنج رقمی"
                                        },
                                        {
                                            "fileformatitem_id": 1065,
                                            "fileformatitem_name": "PORT_NO",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 71,
                                            "internal_name": "FIELDV03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1069,
                                            "fileformatitem_name": "DOWNLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 81,
                                            "internal_name": "FIELDN03",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1070,
                                            "fileformatitem_name": "UPLOAD",
                                            "data_type": "NUMBER",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 82,
                                            "internal_name": "FIELDN04",
                                            "description": null
                                        },
                                        {
                                            "fileformatitem_id": 1071,
                                            "fileformatitem_name": "RECORD_TYPE",
                                            "data_type": "VARCHAR2",
                                            "data_format": null,
                                            "data_length": null,
                                            "val_min": null,
                                            "val_max": null,
                                            "is_required": null,
                                            "order_no": 90,
                                            "internal_name": "TTYPE",
                                            "description": null
                                        }
                                    ]
                                }
                            }
                        ]
                    }
                }
        """;
    }
}
