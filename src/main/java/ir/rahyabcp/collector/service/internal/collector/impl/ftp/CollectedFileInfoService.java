package ir.rahyabcp.collector.service.internal.collector.impl.ftp;

import ir.rahyabcp.collector.api.streamlist.StreamListRemoteRepository;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListDto;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListRequestBody;
import ir.rahyabcp.collector.api.streamlist.dto.StreamListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class CollectedFileInfoService {

    private final StreamListRemoteRepository streamListRemoteRepository;

    @Autowired
    CollectedFileInfoService(StreamListRemoteRepository streamListRemoteRepository) {
        this.streamListRemoteRepository = streamListRemoteRepository;
    }

    List<String> getCollectedFilesName(int nodeId) {
        StreamListResponse response = this.streamListRemoteRepository.callStreamListApi(
                new StreamListRequestBody(nodeId)
        );

        return response.getResponseBody().data().stream().map(StreamListDto::streamName).toList();
    }
}
