package ecommerce;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL94Dialect;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class PGSQLMapDialect extends PostgreSQL94Dialect {


	  @Override
	  public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
	    if (Types.CLOB == sqlTypeDescriptor.getSqlType()) {
	      return LongVarcharTypeDescriptor.INSTANCE;
	    }
	    return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
	  }
	}
