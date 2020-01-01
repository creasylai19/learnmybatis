/**
 *    Copyright 2009-2018 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.executor;

/**
 * @author Clinton Begin
 * add by creasylai 2019.12.31
 */
public class ErrorContext {

  private static final String LINE_SEPARATOR = System.getProperty("line.separator","\n");
  private static final ThreadLocal<ErrorContext> LOCAL = new ThreadLocal<>();

  private ErrorContext stored;
  private String resource;
  private String activity;
  private String object;
  private String message;
  private String sql;
  private Throwable cause;

  private ErrorContext() {
  }

  /**
   *
   * add by creasylai 2019.12.31 返回当前线程的ErrorContext对象
   */
  public static ErrorContext instance() {
    ErrorContext context = LOCAL.get();
    if (context == null) {
      context = new ErrorContext();
      LOCAL.set(context);
    }
    return context;
  }

  /**
   *
   * add by creasylai 2019.12.31 使用新ErrorContext对象覆盖原对象
   */
  public ErrorContext store() {
    ErrorContext newContext = new ErrorContext();
    newContext.stored = this;
    LOCAL.set(newContext);
    return LOCAL.get();
  }

  /**
   *
   * add by creasylai 2019.12.31 使得stored引用为空
   */
  public ErrorContext recall() {
    if (stored != null) {
      LOCAL.set(stored);
      stored = null;
    }
    return LOCAL.get();
  }

  /**
   *
   * add by creasylai 2019.12.31 resource
   */
  public ErrorContext resource(String resource) {
    this.resource = resource;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 activity
   */
  public ErrorContext activity(String activity) {
    this.activity = activity;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 object
   */
  public ErrorContext object(String object) {
    this.object = object;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 message
   */
  public ErrorContext message(String message) {
    this.message = message;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 sql
   */
  public ErrorContext sql(String sql) {
    this.sql = sql;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 cause
   */
  public ErrorContext cause(Throwable cause) {
    this.cause = cause;
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 重置该对象本身
   */
  public ErrorContext reset() {
    resource = null;
    activity = null;
    object = null;
    message = null;
    sql = null;
    cause = null;
    LOCAL.remove();
    return this;
  }

  /**
   *
   * add by creasylai 2019.12.31 toString()
   */
  @Override
  public String toString() {
    StringBuilder description = new StringBuilder();

    // message
    if (this.message != null) {
      description.append(LINE_SEPARATOR);
      description.append("### ");
      description.append(this.message);
    }

    // resource
    if (resource != null) {
      description.append(LINE_SEPARATOR);
      description.append("### The error may exist in ");
      description.append(resource);
    }

    // object
    if (object != null) {
      description.append(LINE_SEPARATOR);
      description.append("### The error may involve ");
      description.append(object);
    }

    // activity
    if (activity != null) {
      description.append(LINE_SEPARATOR);
      description.append("### The error occurred while ");
      description.append(activity);
    }

    // sql
    if (sql != null) {
      description.append(LINE_SEPARATOR);
      description.append("### SQL: ");
      description.append(sql.replace('\n', ' ').replace('\r', ' ').replace('\t', ' ').trim());
    }

    // cause
    if (cause != null) {
      description.append(LINE_SEPARATOR);
      description.append("### Cause: ");
      description.append(cause.toString());
    }

    return description.toString();
  }

}
