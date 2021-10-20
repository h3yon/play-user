package toy.playvip.utils;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import toy.playvip.utils.Point;

@Repository
interface PointRedisRepository extends CrudRepository<Point, String> {
}