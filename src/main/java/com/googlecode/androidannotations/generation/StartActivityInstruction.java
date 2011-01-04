/*
 * Copyright 2010-2011 Pierre-Yves Ricau (py.ricau at gmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.androidannotations.generation;

import com.googlecode.androidannotations.model.Instruction;
import com.googlecode.androidannotations.model.MetaActivity;

public class StartActivityInstruction implements Instruction {

	private static final String CODE = //
	"" + //
			"	@Override\n" + //
			"	public void startActivity(android.content.Intent intent) {\n" + //
			"		android.content.ComponentName component = intent.getComponent();\n" + //
			"		if (component != null) {\n" + //
			"\n" + //
			"			String className = component.getClassName();\n" + //
			"			String generatedClassName = className + \""+MetaActivity.CLASS_SUFFIX+"\";\n" + //
			"\n" + //
			"			boolean generatedClassExists = true;\n" + //
			"			try {\n" + //
			"				Class.forName(generatedClassName);\n" + //
			"			} catch (ClassNotFoundException e) {\n" + //
			"				generatedClassExists = false;\n" + //
			"			}\n" + //
			"\n" + //
			"			if (generatedClassExists) {\n" + //
			"				android.content.ComponentName newComponent = new android.content.ComponentName(component.getPackageName(), generatedClassName);\n" + //
			"				intent.setComponent(newComponent);\n" + //
			"			}\n" + //
			"		}\n" + //
			"		super.startActivity(intent);\n" + //
			"	}\n" + //
			"\n";

	@Override
	public String generate() {
		return CODE;
	}
}
