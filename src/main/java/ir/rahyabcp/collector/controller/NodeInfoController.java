package ir.rahyabcp.collector.controller;


import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.dataaccess.local.entity.NodeInfoEntity;
import ir.rahyabcp.collector.dataaccess.local.repository.NodeInfoRepository;
import ir.rahyabcp.collector.yyy.xxx.ConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/node-info")
public class NodeInfoController {

    private final NodeInfoRepository nodeInfoRepository;
    private final ConfigLoader configLoader;

    @Autowired
    public NodeInfoController(NodeInfoRepository nodeInfoRepository, ConfigLoader configLoader) {
        this.nodeInfoRepository = nodeInfoRepository;
        this.configLoader = configLoader;
    }

    @GetMapping
    ResponseEntity<List<NodeInfoEntity>> getAllNodeInfo() {
        configLoader.load();
        return ResponseEntity.ok().body(
                this.nodeInfoRepository.findAll()
        );
    }

    @GetMapping("/add")
    ResponseEntity<Void> postNodeInfo() {
        NodeInfoEntity nodeInfo = new NodeInfoEntity();
        nodeInfo.setConnectionProtocol(ConnectionProtocol.FTP);
        this.nodeInfoRepository.saveNodeInfo(nodeInfo);
        return ResponseEntity.noContent().build();
    }
}
