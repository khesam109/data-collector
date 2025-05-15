package ir.rahyabcp.collector.dataaccess.remote;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.rahyabcp.collector.dataaccess.remote._node.dto.DataNodeListResponse;

public class Test {

    static String json = """
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
                                        "description": "کذ"
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
                                        "description": "کذ"
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
                                        "description": "کذ"
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
                                         "description": "کذ"
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
            }""";

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        DataNodeListResponse response = objectMapper.readValue(
               json, DataNodeListResponse.class
        );

        System.out.println(response.getResponseBody().dataNodes().size());
    }
}
