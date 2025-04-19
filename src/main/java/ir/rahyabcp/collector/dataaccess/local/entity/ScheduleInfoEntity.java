package ir.rahyabcp.collector.dataaccess.local.entity;

import ir.rahyabcp.collector.common.IntervalUnit;
import jakarta.persistence.*;

@Entity
@Table(name = "SCHEDULE_INFO", schema = "DATA_COLLECTOR")
public class ScheduleInfoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "scheduleInfoSequenceGenerator", sequenceName = "SCHEDULE_INFO_SEQ", allocationSize = 1, schema = "DATA_COLLECTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduleInfoSequenceGenerator")
    private int id;

    @Column(name = "POOLING_INTERVAL", nullable = false)
    private int poolingInterval;

    @Column(name = "INTERVAL_UNIT", nullable = false)
    @Enumerated(EnumType.STRING)
    private IntervalUnit intervalUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoolingInterval() {
        return poolingInterval;
    }

    public void setPoolingInterval(int interval) {
        this.poolingInterval = interval;
    }

    public IntervalUnit getTimeUnit() {
        return intervalUnit;
    }

    public void setTimeUnit(IntervalUnit intervalUnit) {
        this.intervalUnit = intervalUnit;
    }
}
