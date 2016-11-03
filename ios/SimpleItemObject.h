//
//  SimpleItemObject.h
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface SimpleItemObject : NSObject

@property (nonatomic, assign) NSString *labelText;
@property (nonatomic, assign) float width;
@property (nonatomic, assign) float height;

- (instancetype)initWithProperties:(NSString*) labelText withWidth:(float) width andHeight:(float) height;

@end
