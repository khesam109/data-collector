package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import ir.rahyabcp.collector.dataaccess.remote._node.CollectedFileInfoRemoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CollectedFileInfoService {

    private final CollectedFileInfoRemoteRepository collectedFileInfoRemoteRepository;

    @Autowired
    CollectedFileInfoService(CollectedFileInfoRemoteRepository collectedFileInfoRemoteRepository) {
        this.collectedFileInfoRemoteRepository = collectedFileInfoRemoteRepository;
    }

    public List<String> fetch() {
        return this.collectedFileInfoRemoteRepository.fetch().collected();
    }
}
