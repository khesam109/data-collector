package ir.rahyabcp.collector.dataaccess.local.entity;

import ir.rahyabcp.collector.common.TimeUnit;
import jakarta.persistence.*;

@Entity
@Table(name = "SCHEDULE_INFO", schema = "DATA_COLLECTOR")
public class ScheduleInfoEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @SequenceGenerator(name = "scheduleInfoSequenceGenerator", sequenceName = "SCHEDULE_INFO_SEQ", allocationSize = 1, schema = "DATA_COLLECTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scheduleInfoSequenceGenerator")
    private int id;

    @Column(name = "INTERVAL", nullable = false)
    private int interval;

    @Column(name = "TIME_UNIT", nullable = false)
    @Enumerated(EnumType.STRING)
    private TimeUnit timeUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
