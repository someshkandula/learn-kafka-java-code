Java 8 alternative

```java
records.forEach(record -> System.out.println("Consumer : message " + record.value() + " at offset " + record.offset()));
```
