# DbOrmPerformance

Sammenligning af forskellige persistensbiblioteker til Androi



Foreløbige resultater:

    10000-sqlite;492.7;
    20000-sqlite;933.5;
    30000-sqlite;1420.0;
    40000-sqlite;1868.6;
    50000-sqlite;2317.3;
    
    10000-room;275.4;
    20000-room;545.3;
    30000-room;807.1;
    40000-room;1075.3;
    50000-room;1323.8;
    
    10000-serialisering;126.3;
    20000-serialisering;247.6;
    30000-serialisering;362.4;
    40000-serialisering;500.5;
    50000-serialisering;633.7;
    
    10000-realm;77.3;
    20000-realm;115.7;
    30000-realm;174.9;
    40000-realm;233.4;
    50000-realm;287.4;
    
    10000-box;18.8;
    20000-box;31.2;
    30000-box;44.9;
    40000-box;58.8;
    50000-box;72.6;
    
    
    
    reading
    10000-sqlite;42.1;
    20000-sqlite;104.7;
    30000-sqlite;210.6;
    40000-sqlite;329.9;
    50000-sqlite;427.4;
    
    10000-room;28.5;
    20000-room;97.0;
    30000-room;208.4;
    40000-room;336.6;
    50000-room;435.7;
    
    10000-serialisering;183.1;
    20000-serialisering;353.1;
    30000-serialisering;525.1;
    40000-serialisering;695.5;
    50000-serialisering;865.9;
    
    10000-realm;2.1;
    20000-realm;1.5;
    30000-realm;2.1;
    40000-realm;3.2;
    50000-realm;3.7;
    
    10000-box;13.8;
    20000-box;22.5;
    30000-box;35.4;
    40000-box;44.8;
    50000-box;55.8;
    
    
    
    deleting
    10000-sqlite;6.7;
    20000-sqlite;7.4;
    30000-sqlite;7.6;
    40000-sqlite;8.4;
    50000-sqlite;9.2;
    
    10000-room;1.4;
    20000-room;1.9;
    30000-room;2.8;
    40000-room;2.0;
    50000-room;2.8;
    
    10000-serialisering;0.5;
    20000-serialisering;0.2;
    30000-serialisering;0.9;
    40000-serialisering;0.9;
    50000-serialisering;0.9;
    
    10000-realm;2.8;
    20000-realm;4.4;
    30000-realm;6.0;
    40000-realm;7.5;
    50000-realm;8.9;
    
    10000-box;5.0;
    20000-box;7.8;
    30000-box;11.1;
    40000-box;14.7;
    50000-box;16.1;
    
    
    
    updating
    10000-sqlite;789.5;
    20000-sqlite;1489.1;
    30000-sqlite;2260.9;
    40000-sqlite;3029.4;
    50000-sqlite;3745.5;
    
    10000-room;307.7;
    20000-room;612.9;
    30000-room;912.6;
    40000-room;1204.8;
    50000-room;1551.5;
    
    10000-serialisering;120.4;
    20000-serialisering;237.2;
    30000-serialisering;373.3;
    40000-serialisering;482.0;
    50000-serialisering;599.7;
    
    10000-realm;42.7;
    20000-realm;69.6;
    30000-realm;103.6;
    40000-realm;158.8;
    50000-realm;193.2;
    
    10000-box;26.7;
    20000-box;36.6;
    30000-box;50.2;
    40000-box;75.3;
    50000-box;84.8;


## Udestår
Andre serialiseringsmekanismer, binære og jsonbaserede herunder Moshi

https://kotlinlang.org/docs/serialization.html
ProtoBuf?

https://blog.jetbrains.com/kotlin/2021/05/kotlinx-serialization-1-2-released/

## Andre benchmarks


Baseret på https://github.com/mac229/Databases
(https://proandroiddev.com/android-databases-performance-crud-a963dd7bb0eb)

En anden, lidt ældre
https://github.com/AlexeyZatsepin/Android-ORM-benchmark

Nyere, og nok den jeg burde basere mig på
https://medium.com/swlh/android-dbms-performance-comparison-using-the-jetpack-benchmark-library-19581bf67443


