LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'ACCP i7'),(2,'ACCP i10'),(3,'ACCP i11');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'Batch 1',25,1,2010),(2,'Batch 2',25,1,2010),(3,'Batch 3',25,2,2011),(4,'Batch 4',25,2,2011),(5,'Batch 5',25,3,2012);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `tuitions` WRITE;
/*!40000 ALTER TABLE `tuitions` DISABLE KEYS */;
INSERT INTO `tuitions` VALUES (1,2000),(2,1500),(3,1000),(4,500),(5,250);
/*!40000 ALTER TABLE `tuitions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (1,'full',1),(2,'3d4',2),(3,'2d4',3),(4,'1d4',4),(5,'1d6',5);
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES (1,'C',1),(2,'Html',1),(3,'Java',1),(4,'SQL',1),(5,'XML',1),(6,'C',2),(7,'Html',2),(8,'Java',2),(9,'Sql',2),(10,'xml',2),(11,'cloud',3),(12,'java',3),(13,'c#',3),(14,'java2',3),(15,'mysql',3);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;



LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','admin',1,1),(2,'Student1','huythang',1,0),(3,'Student2','123456',0,0),(4,'Student3','123456',0,0),(5,'Student4','123456',1,0),(6,'Student5','123456',1,0),(7,'Student6','123456',1,0),(8,'Student7','123456',1,0),(9,'Student8','123456',0,0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'le huy thang','thanh hoa, Viet Nam','1993-06-10',1,'huythang38@gmail.com',1698924561,1,1,2),(2,'student2','da nang','1990-01-01',1,'asd@gm.co',1698924561,2,1,3),(3,'student3','da nang','1990-01-01',1,' ',1698924561,3,1,4),(4,'student4','da nang','1990-01-01',0,' ',1698924561,4,1,5),(5,'student5','da nang','1990-01-01',1,' ',1698924561,5,3,6),(6,'student6','da nang','1990-01-01',0,' ',1698924561,3,3,7),(7,'student7','da nang','1990-01-01',0,' ',1698924561,1,5,8),(8,'student8','da nang','1990-01-01',0,' ',1698924561,2,5,9);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;



LOCK TABLES `payments` WRITE;
/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` VALUES (1,1000,1),(2,500,2),(3,300,3);
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `records` WRITE;
/*!40000 ALTER TABLE `records` DISABLE KEYS */;
INSERT INTO `records` VALUES (1,100,1,1),(2,100,2,1),(3,100,3,1),(4,100,4,1),(5,100,5,1);
/*!40000 ALTER TABLE `records` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


LOCK TABLES `certificates` WRITE;
/*!40000 ALTER TABLE `certificates` DISABLE KEYS */;
INSERT INTO `certificates` VALUES (1,100,'Distinction',1);
/*!40000 ALTER TABLE `certificates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;