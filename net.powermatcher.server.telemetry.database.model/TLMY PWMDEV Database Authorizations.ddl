--------------------------------------------
-- Authorization Statements on Tables/Views 
--------------------------------------------

 
GRANT SELECT ON TABLE TLMY.AlertData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.AlertData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.AlertData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.AlertData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.AlertData TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.ControlData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.ControlData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.ControlData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.ControlData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.ControlData TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.MeasurementData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.MeasurementData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.MeasurementData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.MeasurementData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.MeasurementData TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.RequestResponseData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.RequestResponseData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.RequestResponseData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.RequestResponseData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.RequestResponseData TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.StatusData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.StatusData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.StatusData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.StatusData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.StatusData TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.MonitoringData TO GROUP PWMREPORTING ;

GRANT DELETE ON TABLE TLMY.MonitoringData TO USER PWMUSER ;

GRANT INSERT ON TABLE TLMY.MonitoringData TO USER PWMUSER ;

GRANT SELECT ON TABLE TLMY.MonitoringData TO USER PWMUSER ;

GRANT UPDATE ON TABLE TLMY.MonitoringData TO USER PWMUSER ;

 
GRANT SELECT ON TABLE TLMY.LatestAlert TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.LatestAlert TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.LatestControl TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.LatestControl TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.LatestMeasurement TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.LatestMeasurement TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.LatestRequestResponse TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.LatestRequestResponse TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.LatestStatus TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.LatestStatus TO USER PWMUSER ;


GRANT SELECT ON TABLE TLMY.MonitoringStatus TO GROUP PWMREPORTING ;

GRANT SELECT ON TABLE TLMY.MonitoringStatus TO USER PWMUSER ;


---------------------------------------
-- Authorization statement on table space 
---------------------------------------

 
GRANT USE OF TABLESPACE SYSTOOLSTMPSPACE TO PUBLIC ;

GRANT USE OF TABLESPACE USERSPACE1 TO USER PWMUSER ;

COMMIT;