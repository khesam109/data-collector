package ir.rahyabcp.collector.dataaccess.local.entity;

import ir.rahyabcp.collector.common.ConnectionProtocol;
import ir.rahyabcp.collector.common.TimeUnit;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "NODE_INFO", schema = "DATA_COLLECTOR")
public class NodeInfoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "nodeInfoSequenceGenerator", sequenceName = "NODE_INFO_SEQ", allocationSize = 1, schema = "DATA_COLLECTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nodeInfoSequenceGenerator")
    private int id;

    @Column(name = "CONNECTION_PROTOCOL", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConnectionProtocol connectionProtocol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_INFO_ID", referencedColumnName = "ID", nullable = false)
    private ScheduleInfoEntity scheduleInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConnectionProtocol getConnectionProtocol() {
        return connectionProtocol;
    }

    public void setConnectionProtocol(ConnectionProtocol connectionProtocol) {
        this.connectionProtocol = connectionProtocol;
    }

    public ScheduleInfoEntity getScheduleInfo() {
        return scheduleInfo;
    }

    public void setScheduleInfo(ScheduleInfoEntity scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    public void addScheduleInfo(int interval, TimeUnit timeUnit) {
        ScheduleInfoEntity scheduleInfoEntity = new ScheduleInfoEntity();
        scheduleInfoEntity.setInterval(interval);
        scheduleInfoEntity.setTimeUnit(timeUnit);
        this.scheduleInfo = scheduleInfoEntity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (!(o instanceof NodeInfoEntity that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
